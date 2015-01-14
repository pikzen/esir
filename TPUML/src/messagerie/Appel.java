package messagerie;
import java.util.Date;

public class Appel extends AbstractCommunication {
		private AbonneOperateur emetteur;
		private AbonneOperateur recepteur;
		private Date finComm;
		
		public Appel(AbonneOperateur e, AbonneOperateur r, Date fin){
			emetteur = e;
			recepteur = r;
			finComm = fin;
		}
		
		public AbonneOperateur getAppelant(){
			return emetteur;
		}
}
