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
	
  //------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------

  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {
    // TODO
    return false;
  }
  @Override
  public void envoyerSMS(String numero, String sms, Date dateSMS)
  {
    // TODO
  }
  @Override
  public void recevoirSMS(MessageSMS message)
  {
    // TODO
  }
  @Override
  public boolean accepterAppel(String numeroAppelant)
  {
    // TODO
    return false;
  }
  @Override
  public void cloreAppel(Date fin)
  {
    // TODO
  }

  //------------------------------------------------------------------------
  // autres méthodes
  //------------------------------------------------------------------------

  // transférer sur le téléphone les SMS du serveur
  public void synchroniser()
  {
    // TODO
  }

  boolean estHorsLigne()
  {
    // TODO
    return true;
  }

  boolean estLibre()
  {
    // TODO
    return true;
  }

} // AbonneOperateur
