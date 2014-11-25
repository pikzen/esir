package main;

import java.util.Random;
import java.util.Scanner;

import tableau.Tableau;
import tableau.Block;

public class NombresPremiers {

	public static int saisie() {
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}

	public static Tableau<Integer> setTableau(int n, Tableau<Integer> tableauRemp) {

		for (int cpt = 2; cpt <= n; cpt++) {

			tableauRemp.set(cpt - 2, cpt);
		}

		return tableauRemp;
	}

	public static boolean estPremier(int n, Tableau<Integer> tableauPrems) {

		for (int cpt = 2; cpt < n; cpt++) {

			tableauPrems.set(cpt - 2, cpt);

		}

		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}

		for (int compteur = 0; compteur < tableauPrems.size(); compteur++) {

			if (n != 0 && n % tableauPrems.get(compteur) == 0) {

				return false; /* On retourne faux */
			}
		}
		return true;
	}

	public static int calculerNombresPremiers(int N, Tableau<Integer> tableauPremier) {
		int cpt = 0;
		int g = 0;

		while (!tableauPremier.full() && (cpt <= N)) {

			if (estPremier(cpt, tableauPremier)) {

				tableauPremier.push_back(cpt);
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
			newTableau.push_back(nombre);

		}
		
		return newTableau;
	}
	
	 static int RechDichoIter(int Elt, Tableau<Integer> tableau ) {
         int min = 0, max = tableau.size()-1, middle = 0;
         
         if(tableau.size() == 0){
        	 return -1;
         }
         
         while(min < max){
        	 middle = (min + max) /2;
        	 if(tableau.get(middle) == Elt){
        		 return middle;
        	 }else if(tableau.get(middle) < Elt){
        		 min = middle + 1;
        	 }else{
        		 max = middle - 1;
        	 }
         }
         
         return -1;
      } 
	 
	 

	public static int eliminerPresents(Tableau<Integer> tab1, Tableau<Integer> tab2) {
		Tableau<Integer> tabTmp = new Block<Integer>(tab1.size());
		int elementsSupprimes = 0;
		
		for (int i = 0; i < tab1.size(); i++) { /* parcourir le tab1, penser dichotomie itérative*/
			
			if(RechDichoIter(tab1.get(i), tab2) == -1){ /* Si on ne trouve pas l'élément tab1 dans tab2*/
				System.out.println("Non trouvé");
				tabTmp.push_back(tab1.get(i));
				
			}else{
				System.out.println("Trouvé");
				elementsSupprimes++;
			}
			
		}
		System.out.println("Premier print");
		printTab(tabTmp);
		
		tab1 = tabTmp;
		System.out.println("---------");
		printTab(tab1);
		
		return elementsSupprimes;

	}
	
	private static void printTab(Tableau<Integer> t1) {
		System.out.print("[");
		for (int i = 0; i < t1.size(); i++) {
			System.out.print(t1.get(i) + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Tableau<Integer> tab = new Block<Integer>(100);
		Tableau<Integer> tab2 = new Block<Integer>(100);
		System.out.println("Entrez un nombre N");
		int N = saisie();
		/*boolean resultat = estPremier(N, tab);
		System.out.println(resultat);*/
		tab = remplirHasard(N);
		tab2 = remplirHasard(N);
		printTab(tab);
		printTab(tab2);
		int somme = calculerNombresPremiers(N, tab2);
		int resultat = eliminerPresents(tab, tab2);
		System.out.println("Résultat éliminer présent");
		System.out.println(resultat);
		printTab(tab);
	}
}
