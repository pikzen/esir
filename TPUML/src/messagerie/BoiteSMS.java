package messagerie;

import java.util.ArrayList;
import java.util.List;

public class BoiteSMS {

	private List<MessageSMS> listeSMS = new ArrayList<MessageSMS>();
	NumeroTelephone numTel = new NumeroTelephone();
	
	public BoiteSMS(NumeroTelephone num){
		numTel = num;
	}
}
