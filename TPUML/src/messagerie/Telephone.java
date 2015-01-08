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
  // méthodes propres
  //------------------------------------------------------------------------

  public void allumer() {
    // TODO
  }
  public void eteindre() {
    // TODO
  }

} // Telephone
