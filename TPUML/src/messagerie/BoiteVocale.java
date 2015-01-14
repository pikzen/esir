package messagerie;

import java.util.ArrayList;
import java.util.List;

public class BoiteVocale {

	List<MessageVocal> listSMSVocaux = new ArrayList<MessageVocal>();
	NumeroTelephone numTel = new NumeroTelephone();
	
	public BoiteVocale(NumeroTelephone num){
		numTel = num;
	}
}
