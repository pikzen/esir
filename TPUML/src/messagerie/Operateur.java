package messagerie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Un Opérateur gère des abonnés et des communications
 */
public class Operateur
{
		private String nom;
		List<Forfait> listeForfaits;

		List<Appel> listeAppels;
		List<NumeroTelephone> listNumeros;
		List<NumeroTelephone> listNumerosLibres;
		List<AbonneOperateur> listeAbonnes;
		List<Operateur> listeOperateurs;
		List<AbstractCommunication> historique;

		/**
		 * Une personne souscrit un abonnement et reçoit un téléphone
		 * @throws Exception 
		 */
		public Telephone souscrire(String nomPersonne,
					     String nomForfait)
		{
			Forfait forf = null;
			for(Forfait f : listeForfaits){
				if(f.getNom() == nomForfait){
					forf = f;
					break;
				}
			}
			
			Telephone telephone = null;
			
			NumeroTelephone tel = null;
			
			if(listNumerosLibres.size() == 0){
				return null;
			}
			tel = listNumerosLibres.get(0);
			listNumerosLibres.remove(0);
			
			if(tel == null){
				return null;
			}
			
			BoiteVocale bv = new BoiteVocale(tel);
			BoiteSMS bs = new BoiteSMS(tel);
			telephone = new Telephone(bs);
		    AbonneOperateur	newAbo = new AbonneOperateur(nomPersonne, telephone, forf, tel, this, bv, bs);
		    telephone.setAbonne(newAbo);
		    listeAbonnes.add(newAbo);
		    return telephone;
		}
		public Operateur(String nomOp) {
				this.nom = nomOp;
				this.listeForfaits 		= new ArrayList<Forfait>();
				this.listeAppels 		= new ArrayList<Appel>();
				this.listeAbonnes 		= new ArrayList<AbonneOperateur>();
				this.listeOperateurs 	= new ArrayList<Operateur>();
				this.listNumerosLibres  = new ArrayList<NumeroTelephone>();
				this.listNumeros        = new ArrayList<NumeroTelephone>();
				this.historique         = new ArrayList<AbstractCommunication>();
				listNumeros.add(new NumeroTelephone("2"));
				listNumeros.add(new NumeroTelephone("+33(0)700000004"));
				listNumeros.add(new NumeroTelephone("3"));
				listNumeros.add(new NumeroTelephone("4"));
				listNumeros.add(new NumeroTelephone("5"));
				listNumeros.add(new NumeroTelephone("6"));
				listNumeros.add(new NumeroTelephone("7"));
				listNumeros.add(new NumeroTelephone("8"));
				listNumeros.add(new NumeroTelephone("9"));
				for(NumeroTelephone n : listNumeros){
					listNumerosLibres.add(n);
				}
				
		}

		public boolean estAbonne(String numero) {
				for (AbonneOperateur ab : listeAbonnes)
						if (ab.getTelephoneNumber().equals(numero)) return true;

				return false;
		}

		public AbonneOperateur getAbonne(String numero) {
				AbonneOperateur abonne = null;
				for (AbonneOperateur ab : listeAbonnes) {
						if (ab.getTelephoneNumber().getNumero().equals(numero)) {
								abonne = ab;
								break;
						}
				}

				// Aucun abonné avec ce numéro. On demande aux autres opérateurs si ils ont ce numéro
				if (abonne == null) {
						for (Operateur op : listeOperateurs) {
								if (op.estAbonne(numero)) {
										abonne = op.getAbonne(numero);
										break;
								}
						}
				}

				return abonne;
		}

		/**
		 * Établir une communication
		 * @param emetteur
		 * @param numeroDestinataire
		 * @param msgVocal : message en cas d'indisponibilité
		 * @param dateAppel
		 * @return vrai si la communication a été établie
		 */
		public boolean etablirCommunication(AbonneOperateur emetteur, String numeroDestinataire, String msgVocal, Date dateAppel)
		{
				// On ne sait pas encore quel type de communication on va initier (appel ou message vocal)
				AbstractCommunication comm = null;
				// On a besoin de vérifier si le numéro existe bien.
				AbonneOperateur recepteur = getAbonne(numeroDestinataire);
		
				// Aucun opérateur ne connait ce numéro. La connection n'est pas établie
				if (recepteur == null)
						return false;
				else {
						if (recepteur.estHorsLigne() || !recepteur.estLibre()) {
							comm = new CommMessageVocal(emetteur, recepteur, msgVocal, dateAppel);

						}
						else if (recepteur.estLibre()) {
							comm = new Appel(emetteur, recepteur, dateAppel);
							// On doit encore vérifier si le recepteur accepte l'appel. Si non, on considere
							// que la communication n'a pas été établie.
							if (!recepteur.accepterAppel(emetteur.getTelephoneNumber().getNumero())) {
									return false;
							}

							this.listeAppels.add((Appel)comm);
						}
						else
								return false;
				}

				// La connection à été établie sans problème, on peut considerer qu'elle est réussie.
				// Cela ne prends pas en compte le fait que l'utilisateur peut raccrocher après, ou bien ne pas 
				// accepter l'appel
				return true;
		}

		/**
		 * poster un SMS
		 * @param emetteur
		 * @param numeroDestinataire
		 * @param sms : le texte du SMS
		 * @pamra dateEnvoi
		 */
		public void	posterSMS(AbonneOperateur emetteur,	String numeroDestinataire, String sms, Date dateEnvoi)
		{

			AbonneOperateur recepteur = getAbonne(numeroDestinataire);
			if (recepteur == null) {
				return;
			}
			
			MessageSMS mess = new MessageSMS(emetteur, recepteur, dateEnvoi, sms);
			this.historique.add(new CommSMS(emetteur, recepteur));
			recepteur.recevoirSMS(mess);
		}

		/**
		 * un abonné met fin à une communication
		 * @param abonne : celui qui clôt
		 * @param date de fin de communication
		 */
		public void cloreAppel(AbonneOperateur abonne, Date fin)
		{

			Appel ap = null;
			for (Appel appel : listeAppels) {
				if (appel.getAppelant().equals(abonne.getTelephoneNumber())) {
					ap = appel;
					break;
				}
			}
			this.historique.add(ap);
			this.listeAppels.remove(ap);

		}
		
		@Override
		public String toString(){
			return "L'opérateur : "+this.nom+" possède : "+listeAbonnes.size()+" abonné(s)";
		}

} // Operateur
