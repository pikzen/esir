package messagerie;

import java.util.Date;

public class CommMessageVocal extends AbstractCommMessage {
	
	private AbonneOperateur emetteur;
	private AbonneOperateur recepteur;
	private String msgVocal;
	private Date dateCall;
	
	
	public CommMessageVocal(AbonneOperateur emetteur2,
			AbonneOperateur recepteur2, String msgVocal, Date dateAppel) {
		emetteur = emetteur2;
		recepteur = recepteur2;
		this.msgVocal = msgVocal;
		dateCall = dateAppel;
	}
	
}
