package messagerie;

import java.util.Date;


public class MessageSMS extends AbstractMessage{

	AbonneOperateur emetteur;
	AbonneOperateur recepteur;
	Date dateSMS;
	String sms;
	
	public MessageSMS(AbonneOperateur e, AbonneOperateur r, Date dateEnvoi, String s){
		emetteur = e;
		recepteur = r;
		dateSMS = dateEnvoi;
		sms = s;
	}
}
