package messagerie;
import java.util.Date;

/**
 * Informations d'Abonné gérées par l'opérateur
 */
public class AbonneOperateur implements GestionCommunication
{

	private BoiteSMS boiteS;
	private BoiteVocale boiteV;
	private Operateur operateur;
	private NumeroTelephone numTel;
	private Forfait forfait;
	private Telephone telephone;
	private String nomAbonne;
	
	public AbonneOperateur(String nom, Telephone tel, Forfait forfait, NumeroTelephone numTel, Operateur op, BoiteVocale boitV, BoiteSMS boitS){
		nomAbonne = nom;
		telephone = tel;
		this.forfait = forfait;
		this.numTel = numTel;
		operateur = op;
		boiteV = boitV;
		boiteS = boitS;
	}

  public getTelephoneNumber() {
    return this.numTel.getNumero();
  }
	
  //------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------

  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {

    return this.operateur.etablirCommunication(this, numero, msgVocalSiOccupe, dateDebut);

  }
  @Override
  public void envoyerSMS(String numero, String sms, Date dateSMS)
  {

    this.operateur.posterSMS(this, numero, sms, dateSMS);

  }
  @Override
  public void recevoirSMS(MessageSMS message)
  {
    if(telephone.allume == true){
    	telephone.recevoirSMS(message);
    }
  }
  
  @Override
  public boolean accepterAppel(String numeroAppelant)
  {
    if(this.estHorsLigne()){
    	return false;
    }
    
    if(this.estLibre()){
    	return true;
    }
    
    return true;
  }
  @Override
  public void cloreAppel(Date fin)
  {
    operateur.cloreAppel(this, fin);
  }

  //------------------------------------------------------------------------
  // autres méthodes
  //------------------------------------------------------------------------

  // transférer sur le téléphone les SMS du serveur
  public void synchroniser()
  {
    if(telephone.allume == true){
    	
    }
  }

  boolean estHorsLigne()
  {
	if(telephone.allume == false){
		return true;
	}
	return false;
  }

  boolean estLibre()
  {
    if(telephone.allume == true){
    	return true;
    }
    return false;
 }

} // AbonneOperateur
