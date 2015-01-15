package messagerie;
import java.util.Date;

/**
 * utilisation du téléphone par l'abonné
 */

public class Telephone implements GestionCommunication
{

	private BoiteSMS boiteSMS;
	private AbonneOperateur abonneOp;
	public boolean allume = false;
	
	public Telephone(BoiteSMS boiteS){
		boiteSMS = boiteS;
	}
  //------------------------------------------------------------------------
  // méthodes de l'interface GestionCommunication
  //------------------------------------------------------------------------
  @Override
  public boolean appeler(String numero, String msgVocalSiOccupe, Date dateDebut)
  {
		return abonneOp.appeler(numero, msgVocalSiOccupe, dateDebut);
  }
  @Override
  public void envoyerSMS(String numero, String sms, Date dateSMS)
  {
		abonneOp.envoyerSMS(numero, sms, dateSMS);
  }
  @Override
  public void recevoirSMS(MessageSMS message)
  {
		abonneOp.recevoirSMS(message);
  }
  @Override
  public boolean accepterAppel(String numeroAppelant)
  {
		return true;
  }
  @Override
  public void cloreAppel(Date fin)
  {
		abonneOp.cloreAppel(fin);
  }

  //------------------------------------------------------------------------
  // méthodes propres
  //------------------------------------------------------------------------

  public void allumer() {
	abonneOp.synchroniser();
    allume = true;
  }
  public void eteindre() {
    allume = false;
  }
  
  public void setAbonne(AbonneOperateur abo){
	  abonneOp = abo;
  }
  
  @Override
  public String toString(){
	  return "Le téléphone appartient à : "+abonneOp.getNom()+" le numéro est : "+abonneOp.getTelephoneNumber().getNumero()+" et il est actuellement : "+(allume?" allume " : "éteint")+" elle possède : "+boiteSMS.getNbSMS()+" message(s)";
  }

} // Telephone
