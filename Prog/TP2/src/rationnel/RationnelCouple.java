package rationnel;

import types.Rationnel;


public class RationnelCouple implements Rationnel {
	private Couple<Integer, Integer> Valeurs;

	//===================================================================
	// CONSTRUCTORS
	//===================================================================
	/**
	* Construit un RationnelCouple avec un dénominateur égal à 1
	* @param num Numérateur du rationnel
	*/
	public RationnelCouple (int num) {
		this(num, 1);
	}

	/**
	* Construit un RationnelCouple avec numérateur et dénominateur
	* @param num Numérateur du rationnel
	* @param den Dénominateur du rationnel
	*/
	public RationnelCouple(int num, int den) {
		assert den != 0;
		
		// Changement de signe si les deux parties sont de signe n�gatif
		if (num < 0 && den < 0) {
			num = -num;
			den = -den;
		}
			
		// Si on peut simplifier la fraction vers un r�sultat entier
		if (num % den == 0 && den != 1) {
			num = num / den;
			den = 1;
		}

		int a = num;
		int b = den;

		// calcul du pgcd pour la simplification tu vois t'as vu
		while(b > 0)
		{
			int c = a % b;
			a = b;
			b = c;
		}

		num /= a;
		den /= a;
		
		this.Valeurs = new Couple<Integer, Integer>(num, den);
	}

	/**
	* Copie un Rationnel
	* @param copy Rationnel à copier
	*/
	public RationnelCouple(Rationnel copy) {
		this(copy.getNumerateur(), copy.getDenominateur());
	}

	//===================================================================
	// GETTERS// SETTERS
	//===================================================================
	public int getNumerateur() {
		return Valeurs.getFirst();
	}

	public int getDenominateur() {
		return Valeurs.getSecond();
	}

	//===================================================================
	// COMPARISONS
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
			result = new RationnelCouple(this.getNumerateur() + r2.getNumerateur(), this.getDenominateur());
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
			result = new RationnelCouple(num, den);
		}

		return result;
	}

	/**
	* Renvoie l'inverse de ce rationnel
	*/
	public Rationnel inverse() {
		return new RationnelCouple(this.getDenominateur(), this.getNumerateur());
	}

	/**
	* Renvoie une représentation en String de ce rationnel
	*/
	public String toString() {
		return this.getNumerateur() + "/" + this.getDenominateur();
	}

}
