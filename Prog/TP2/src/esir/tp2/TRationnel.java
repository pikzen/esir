package esir.tp2;

import java.util.Scanner;
import rationnel.*;
import types.*;

public class TRationnel {
	public static Rationnel makeRationnel(int num, int den){
		Rationnel r1;
		if (num % 2 == 0) {
			r1 = new RationnelSimple(num, den);
		}
		else {
			r1 = new RationnelCouple(num, den);
		}

		return r1;
	}

	/**
	 * Saisie numérateur et dénominateur
	 */

	public static Rationnel lireRationnel(Scanner input){

		int num = -1;
		int den = -1;

		System.out.print("Entrez le numérateur   : ");
		num = input.nextInt();
		System.out.print("Entrez le dénominateur : ");
		den = input.nextInt();

		Rationnel resultat = makeRationnel(num, den);

		return resultat;

	}

	public static void insererRationnel(Rationnel nouveau, Rationnel[] rationnels, int nb) {
		// On insere l'élément, puis on trie
		rationnels[nb] = nouveau;
		nb++;
		
		for (int i = 1; i < nb; i++) {
			int cpt = i; /* Le compteur */
			
			 /* Tant que élément du dessous supérieur on le déplace */
			while (cpt > 0 && 
				   rationnels[cpt - 1].valeur() > rationnels[cpt].valeur())
			{
				Rationnel tmp = rationnels[cpt];
				rationnels[cpt] = rationnels[cpt - 1]; /* on le déplace à la place d'après */
				rationnels[cpt - 1] = tmp;
				cpt--; /* le compteur décrémente */
			}
		}		
	}

	public static void afficher(Rationnel[] elements, int nb) {
		for (int i = 0; i < nb; i++) {
			System.out.println("Rationnel : " + elements[i] + ", Valeur : " + elements[i].valeur());
		}
	}

	public static void somme(Rationnel[] elements, int nb) {
		Rationnel sum = makeRationnel(0, 1);

		for (int i = 0; i < nb; i++) {
			sum = sum.somme(elements[i]);
		}

		System.out.println("Somme : " + sum);
	}

	public static void main(String[] args) {
		Scanner entree = new Scanner(System.in);
		Rationnel r1 = null, r2 = null;
		Rationnel[] rationnels = new Rationnel[50];
		int lastPos = -1;
		int nbRat = 0;

		// On lit une infinité de rationnels.
		// Si l'utilisateur entre un rationnel avec pour valeur 0, on s'arretera.
		while (true) {
			if (r1 != null) { r2 = makeRationnel(r1.getNumerateur(), r1.getDenominateur()); }
			Rationnel rat = lireRationnel(entree);
			r1 = makeRationnel(rat.getNumerateur(), rat.getDenominateur());

			// Insertion du rationnel dans le tableau
			lastPos++;
			rationnels[lastPos] = r1;

			if (r1.getNumerateur() == 0) {
				System.out.println("Le rationnel a pour valeur 0. Arret.");
				break;
			}

			System.out.println("Rationnel actuel : " + r1.toString());
			if (r2 != null) {
				System.out.println("Somme : " + r1.somme(r2));
			}

			System.out.println("Inverse : " + r1.inverse());

			System.out.println("Valeur : " + r1.valeur());

			if (r2 != null) {
				System.out.println("Plus petit que le precedent : " + r1.compareTo(r2));

				System.out.println("Egal au precedent : " + r1.equals(r2));
			}
			nbRat++;
			System.out.println("===== Affichage du tableau actuel");
			afficher(rationnels, nbRat);
			somme(rationnels, nbRat);
			System.out.println("============================================");
		}
	}
}
