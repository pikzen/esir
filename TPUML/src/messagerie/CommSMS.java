package messagerie;

public class CommSMS extends AbstractCommMessage {
	private AbonneOperateur emetteur;
	private AbonneOperateur recepteur;
	
	public CommSMS(AbonneOperateur e, AbonneOperateur r){
		emetteur = e;
		recepteur = r;
	}
	
}
