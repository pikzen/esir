package messagerie;

public class Forfait {
	
	private String nom;
	private int prixInitial;
	private boolean comInclus;
	private float consultBoite;
	private float prixSMS;
	private float prixMin;
	
	public Forfait(String nom, int prixInitial, boolean comInclus, float consultBoite, float prixSMS, float prixMin){
		this.nom = nom;
		this.prixInitial = prixInitial;
		this.comInclus = comInclus;
		this.consultBoite = consultBoite;
		this.prixSMS = prixSMS;
		this.prixMin = prixMin;
	}
	
	public String getNom(){
		return nom;
	}
}
