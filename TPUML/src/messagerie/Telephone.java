package messagerie;
import java.util.Date;

/**
 * utilisation du téléphone par l'abonné
 */

public class Telephone implements GestionCommunication
{

	private BoiteSMS boiteSMS;
	private AbonneOperateur abonneOp;
	
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
		abonneOp.accepterAppel(numeroAppelant);
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
    // TODO
  }
  public void eteindre() {
    // TODO
  }

} // Telephone
