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
		List<AbonneOperateur> listeAbonnes;
		List<Operateur> listeOperateurs;
		List<AbstractCommunication> historique;
		/**
		 * Une personne souscrit un abonnement et reçoit un téléphone
		 */
		public Telephone souscrire(String nomPersonne,
					     String nomForfait)
		{
			Forfait forf;
			for(Forfait f : listeForfaits){
				if(f.getNom() == nomForfait){
					forf = f;
					break;
				}
			}
			  
		    AbonneOperateur	newAbo = new AbonneOperateur(nomPersonne, forf, );
		    return null;
		}
		public Operateur(String nomOp) {
				this.nom = nomOp;
				this.listeForfaits 		= new ArrayList<Forfait>();
				this.listeAppels 		= new ArrayList<Appel>();
				this.listeAbonnes 		= new ArrayList<AbonneOperateur>();
				this.listeOperateurs 	= new ArrayList<Operateur>();
		}

		public boolean estAbonne(String numero) {
				for (AbonneOperateur ab : listeAbonnes)
						if (ab.getTelephoneNumber().equals(numero)) return true;

				return false;
		}

		public AbonneOperateur getAbonne(String numero) {
				AbonneOperateur abonne = null;
				for (AbonneOperateur ab : listeAbonnes) {
						if (ab.getTelephoneNumber().equals(numero)) {
								abonne = ab;
								break;
						}
				}

				// Aucun abonné avec ce numéro. On demande aux autres opérateurs si ils ont ce numéro
				if (abonne == null) {
						for (Operateur op : listeOperateurs) {
								if (op.estAbonne(numeroDestinataire)) {
										abonne = op.getAbonne(numeroDestinataire);
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
							comm = new Appel(emetteur, recepteur, date);
							// On doit encore vérifier si le recepteur accepte l'appel. Si non, on considere
							// que la communication n'a pas été établie.
							if (!recepteur.accepterAppel(emetteur.getTelephoneNumber()) {
									return false;
							}

							this.listeAppels.add(comm);
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
			if (recepteur == null) return;
			
			MessageSMS mess = new MessageSMS(emetteur, recepteur, sms, dateEnvoi);
			this.historique.add(mess)
			recepteur.recevoirSMS(mess);
		}

		/**
		 * un abonné met fin à une communication
		 * @param abonne : celui qui clôt
		 * @param date de fin de communication
		 */
		public void cloreAppel(AbonneOperateur abonne, Date fin)
		{
			Appel ap;
			for (Appel appel : listeAppels) {
				if (appel.getAppelant().equals(abonne.getTelephoneNumber())) {
					ap = appel;
					break;
				}
			}
			this.historique.add(ap);
			this.listeAppels.remove(ap);
		}

} // Operateur
