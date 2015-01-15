package messagerie;

import java.util.ArrayList;
import java.util.List;

public class BoiteSMS {

	private List<MessageSMS> listeSMS = new ArrayList<MessageSMS>();
	NumeroTelephone numTel;
	
	public BoiteSMS(NumeroTelephone num){
		numTel = num;
	}
	
	public void getMessages(){
		this.listeSMS = new ArrayList<MessageSMS>();
	}
	
	public int getNbSMS(){
		return listeSMS.size();
	}
	
	public void ajouter(MessageSMS message){
		listeSMS.add(message);
	}
}
