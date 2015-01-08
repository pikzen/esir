package messagerie;
import java.util.Date;

/**
 * Un Opérateur gère des abonnés et des communications
 */
public class Operateur
{

  /**
   * Une personne souscrit un abonnement et reçoit un téléphone
   */
  public Telephone souscrire(String nomPersonne,
			     String nomForfait)
  {
    // TODO
    return null;
  }

  /**
   * Établir une communication
   * @param emetteur
   * @param numeroDestinataire
   * @param msgVocal : message en cas d'indisponibilité
   * @param dateAppel
   * @return vrai si la communication a été établie
   */
  public boolean
  etablirCommunication(AbonneOperateur emetteur, 
		       String numeroDestinataire,
		       String msgVocal,
		       Date dateAppel)
  {
    // TODO
    return false;
  }

  /**
   * poster un SMS
   * @param emetteur
   * @param numeroDestinataire
   * @param sms : le texte du SMS
   * @pamra dateEnvoi
   */
  public void
    posterSMS(AbonneOperateur emetteur,
	      String numeroDestinataire,
	      String sms,
	      Date dateEnvoi)
  {
    // TODO
  }

  /**
   * un abonné met fin à une communication
   * @param abonne : celui qui clôt
   * @param date de fin de communication
   */
  public void cloreAppel(AbonneOperateur abonne, Date fin)
  {
    // TODO
  }

} // Operateur
