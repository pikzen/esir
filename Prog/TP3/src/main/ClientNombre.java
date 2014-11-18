package main;

import java.util.Random;
import java.util.Scanner;

import tableau.Block;

public class ClientNombre {

	public static int saisie() {
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}


	public static boolean estPremier(int n, Block<Integer> tableauPrems) {
		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}

		for (int compteur = 0; compteur < tableauPrems.size(); compteur++) {
			if (n % tableauPrems.get(compteur) == 0) {
				return true; /* On retourne faux */
			}
		}
		return false;
	}

	static int calculerNombrePremiers(int N, Block<Integer> tableauPremier) {
		int lastInt = 2;
		
		for (int i = 2; tableauPremier.size() < 100 && i <= N; i++) {
			lastInt = i;
			if (!estPremier(i, tableauPremier)) {
				boolean isPrime = true;
				for (int j = 0; j < tableauPremier.size(); j++) {
					if (i % tableauPremier.get(j) == 0) {
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) tableauPremier.push_back(i);
			}
		}
		
		return lastInt;
		
	}

	public static void remplirHasard(int nb) {
		Block<Integer> newTableau = new Block<Integer>(nb); 
		
		Random r1 = new Random();

		for (int i = 0; i < nb; i++) {

			int nombre = (r1.nextInt(nb));
			newTableau.set(i, nombre);

		}
	}

	public static void eliminerPresents(Block<Integer> tab1, Block<Integer> tab2) {
		
		
		for (int i = 0; i < tab1.size(); i++) { /* parcourir le tab1, penser dichotomie itérative*/
			
			/* Pour chaque élément de tab1 faire fonction dichotomie*/
			/* Voir comment supprimer l'élément courant */
		}

	}

	public static void main(String[] args) {
		Block<Integer> tab = new Block<Integer>(100);
		System.out.println("Entrez un nombre N");
		int N = saisie();
		int last = calculerNombrePremiers(N, tab);
		for (int i = 0; i < tab.size(); i++) {
				System.out.println(tab.get(i));
		}
		System.out.println("Dernier élément testé : " + last);
		
	}
}
