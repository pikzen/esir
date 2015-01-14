package messagerie;

public class NumeroTelephone {
		private Operateur operateur;
		private AbonneOperateur abonne;
		private String numero;

		public String getNumero() {
			return this.numero;
		}
		
		public Operateur getOperateur(){
			return this.operateur;
		}
		
		public void setAbonne(AbonneOperateur ab){
			abonne = ab;
		}
}
