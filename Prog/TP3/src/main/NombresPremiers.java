package main;

import java.util.Random;
import java.util.Scanner;

import tableau.Block;

public class NombresPremiers {

	public static int saisie() {
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}

	public static Block<Integer> setTableau(int n, Block<Integer> tableauRemp) {

		for (int cpt = 2; cpt <= n; cpt++) {

			tableauRemp.set(cpt - 2, cpt);
		}

		return tableauRemp;
	}

	public static boolean estPremier(int n, Block<Integer> tableauPrems) {

		for (int cpt = 2; cpt < n; cpt++) {

			tableauPrems.set(cpt - 2, cpt);

		}

		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}

		for (int compteur = 0; compteur < tableauPrems.size(); compteur++) {

			if (n % tableauPrems.get(compteur) == 0) {

				return false; /* On retourne faux */
			}
		}
		return true;
	}

	static int calculerNombrePremiers(int N, Block<Integer> tableauPremier) {
		int cpt = 0;
		int g = 0;

		while (!tableauPremier.full() && (cpt <= N)) {

			if (estPremier(cpt, tableauPremier)) {

				tableauPremier.set(g, cpt);
				g++;
			}

			cpt++;
		}

		if (tableauPremier.full() && (cpt <= N)) {
			return cpt - 1;
		} else {
			return N;
		}
	}

	public static Block<Integer> remplirHasard(int nb) {
		Block<Integer> newTableau = new Block<Integer>(nb); /*
															 * Tableau Block de
															 * capacité nb
															 */
		Random r1 = new Random();

		for (int i = 0; i < nb; i++) {

			int nombre = (r1.nextInt(nb));
			newTableau.set(i, nombre);

		}
		
		for(int z = 0; z < nb; z++){
			System.out.println(newTableau.get(z));
		}
		
		return newTableau;
	}

	public static void eliminerPresents(Block<Integer> tab1, Block<Integer> tab2) {
		
		
		for (int i = 0; i < tab1.size(); i++) { /* parcourir le tab1, penser dichotomie itérative*/
			
			/* Pour chaque élément de tab1 faire fonction dichotomie*/
			/* Voir comment supprimer l'élément courant */
			
			for(int cpt = 0; cpt < tab2.size(); cpt++){
				if(tab1.get(i) == tab2.get(cpt)){
					tab1.push_back(tab1.get(i));
					tab1.pop_back();
				}
			}
		}

	}

	public static void main(String[] args) {
		Block<Integer> tab = new Block<Integer>(100);
		System.out.println("Entrez un nombre N");
		int N = saisie();
		/* tab = setTableau(N, tab); */
		/*boolean resultat = estPremier(N, tab);
		System.out.println(resultat);*/
		tab = remplirHasard(N);
	}
}
