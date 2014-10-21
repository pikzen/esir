package rationnel;

import java.util.Scanner;



public class RationnelSimple implements Rationnel {
	/**
	* Numérateur du rationnel
	*/
	private int Numerator;
	/**
	* Dénominateur du rationnel
	*/
	private int Denominator;



	//===================================================================
	// CONSTRUCTORS
	//===================================================================
	/**
	* Construit un RationnelSimple avec un dénominateur égal à 1
	* @param num Numérateur du rationnel
	*/
	public RationnelSimple(int num) {
		this.Numerator     	= num;
		this.Denominator 	= 1;
	}

	/**
	* Construit un RationnelSimple avec numérateur et dénominateur
	* @param num Numérateur du rationnel
	* @param den Dénominateur du rationnel
	*/
	
	public RationnelSimple(int num, int den) {
		Numerator 	= num;
		Denominator = den;
	}

	/**
	* Copie un Rationnel
	* @param copy Rationnel à copier
	*/
	public RationnelSimple(Rationnel copy) {
		this.Numerator	= copy.getNumerateur();
		this.Denominator = copy.getDenominateur();
	}

	//===================================================================
	// GETTERS// SETTERS
	//===================================================================
	public int getNumerateur() {
		return this.Numerator;
	}

	public int getDenominateur() {
		return this.Denominator;
	}

	//===================================================================
	// COMPARAISONS
	//===================================================================
	public boolean equals(Rationnel r2) {
		return this.getDenominateur() == r2.getDenominateur() &&
			this.getNumerateur() == r2.getNumerateur();
	}

	public int compareTo(Rationnel r2) {
		if (this.equals(r2)) return 0;

		if (this.valeur() - r2.valeur() < 0) return -1;
		else return 1;
	}

	//===================================================================
	// AUTRES
	//===================================================================
	/**
	 * Fonction makeRationnel
	 */
	
		static Rationnel makeRationnel(int num, int den){
			
			RationnelSimple r1 = new RationnelSimple(num, den);
			
			return r1;
		}

	
	/**
	 * Saisie numérateur et dénominateur
	 */
	
	static Rationnel lireRationnel(Scanner input){
		
		int num;
		int den;
		
		System.out.println("Entrez le numérateur : \n");
		num = input.nextInt();
		System.out.println("Entrez le dénominateur : \n");
		den = input.nextInt();
		
		RationnelSimple resultat = new RationnelSimple(num, den);
		
		return resultat;
		
	}
	
	
	/**
	 * Méthode de tri
	 */
	
	public static void InsertionTri(Rationnel[] tabTraitement, int taille) { /* La fonction  de tri par insertion */

		int cpt;
		Rationnel elementCourant;

		for (int i = 1; i < taille; i++) {
			elementCourant = tabTraitement[i]; /* Contient l'élément courant */
			cpt = i - 1; /* Le compteur */

			while (cpt >= 0 && tabTraitement[cpt].valeur() > elementCourant.valeur()) /* Tant que élément du dessous supérieur on le déplace */
				
			{
				tabTraitement[cpt + 1] = tabTraitement[cpt]; /* on le déplace à la place d'après */
				cpt--; /* le compteur décrémente */
			}
			tabTraitement[cpt + 1] = elementCourant; /* On met l'élément courant dans compteur +1 quand boucle finie */
		}
	}
	
	
	/**
	 * Méthode pour insérer un rationnel !!
	 */
	
	
	static void insererRationnel(Rationnel nouveau, Rationnel [] lesRationnels, int nb){
		InsertionTri(lesRationnels, lesRationnels.length-1);
		lesRationnels[lesRationnels.length] = nouveau;
		InsertionTri(lesRationnels, lesRationnels.length-1);
	}
	
	
	/**
	* Renvoie la valeur réelle de ce rationnel
	*/
	public double valeur() {
		return (double)this.getNumerateur() / (double)this.getDenominateur();
	}

	/**
	* Ajoute deux rationnels et renvoie le résultat
	*/
	public Rationnel somme(Rationnel r2) {
		Rationnel result;

		// Si le dénominateur est égal, on peut simplement ajouter les numérateurs et renvoyer le résultat.
		// Sinon, on doit multiplier numérateurs et dénominateurs entre eux, etc.
		if (this.getDenominateur() == r2.getDenominateur()) {
			result = new RationnelSimple(this.getNumerateur() + r2.getNumerateur(), this.getDenominateur());
		}
		else {
			int den1 = this.getDenominateur();
			int den2 = r2.getDenominateur();

			// On trouve le facteur commun aux deux rationnels.
			while (den1 != den2) {
				if (den1 < den2) den1 = den1+this.getDenominateur();
				else den2 = den2+r2.getDenominateur();
			}

			int factor1 = den1 / this.getDenominateur();
			int factor2 = den2 / r2.getDenominateur();

			int num = this.getNumerateur() * factor1 + r2.getNumerateur() * factor2;
			int den = den1;
			result = new RationnelSimple(num, den);
		}

		return result;
	}

	/**
	* Renvoie l'inverse du ce rationnel
	*/
	public Rationnel inverse() {
		return new RationnelSimple(this.getDenominateur(), this.getNumerateur());
	}

	/**
	* Renvoie une représentation en String de ce rationnel
	*/
	public String toString() {
		return this.getNumerateur() + "/" + this.getDenominateur();
	}
	
}
