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

			tableauRemp.push_back(cpt);
		}

		return tableauRemp;
	}

	public static boolean estPremier(int n, Tableau<Integer> tableauPrems) {
		
		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}

		for (int compteur = 0; compteur < tableauPrems.size(); compteur++) { /* On parcourt de 0 à la fin du tableau */
			int val = tableauPrems.get(compteur); /* On met l'élément courant dans une variable*/
			if (val == 0) {
				return false;
			}
			
			if (n % val == 0) { /* */
				return false; /* On retourne faux */
			}
		}
		return true;
	}

	
	public static int calculerNombresPremiers(int N, Tableau<Integer> tableauPremier) {
		int cpt = 2;
		while (!tableauPremier.full() && (cpt <= N)) {
			if (estPremier(cpt, tableauPremier)) {
				tableauPremier.push_back(cpt);
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

	private static void insertionSort(Tableau<Integer> tab) {
		 // On itère sur les éléments non triès. (On considère que l'élément à l'index 0 est déjà trié et le sera lorsqu'on inserera les autres éléments)
		 // On trouve la position à laquelle inserer l'élément actuelle.

		 for (int unsortedElements = 1; unsortedElements < tab.size(); unsortedElements++) {
		 	int j = unsortedElements;
		 	while (j > 0  && tab.get(j - 1) > tab.get(j)) {
		 		int temp = tab.get(j);
		 		tab.set(j, tab.get(j-1));
		 		tab.set(j-1, temp);
		 		j = j-1;
		 	}
		 }
	}

	private static int RechDichoIter(int check, Tableau<Integer> nums ) {
	        int hi = nums.size() - 1;
	        int lo = 0;
	        int guess = 0;
	        while(hi >= lo){
                guess = lo + ((hi - lo) / 2);
                if(nums.get(guess) > check){
                    hi = guess - 1;
                }else if(nums.get(guess) < check){
                    lo = guess + 1;
                }else{
                    return guess;
                }
	        }
	        return -1;
      }



	public static int eliminerPresents(Tableau<Integer> tab1, Tableau<Integer> tab2) {
		Tableau<Integer> tabTmp = new Block<Integer>(tab1.size());
		insertionSort(tab2);
		int elementsSupprimes = 0;

		System.out.print(" ");
		for (int i = 0; i < tab1.size(); i++) { /* parcourir le tab1, penser dichotomie itérative*/
			if(RechDichoIter(tab1.get(i), tab2) == -1){ /* Si on ne trouve pas l'élément tab1 dans tab2*/
				tabTmp.push_back(tab1.get(i));

			}else{
				elementsSupprimes++;
			}

		}
		// On vide le tableau et on le remplit avec le contenu de tabTmp
		while (!tab1.empty()) tab1.pop_back();
		while (!tabTmp.empty()) {
			tab1.push_back(tabTmp.get(tabTmp.size() - 1));
			tabTmp.pop_back();
		}

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

		// Remplissage au hasard des tableaux
		tab = remplirHasard(N);
		tab2 = remplirHasard(N);

		System.out.println("TABLEAUX INITIAUX");
		System.out.println("======================================");
		printTab(tab);
		printTab(tab2);
		System.out.println("voici le test calculnombrepremier");
		int somme = calculerNombresPremiers(N, tab2);
		int resultat = eliminerPresents(tab, tab2);
		System.out.println("======================================");
		System.out.println("Nombre d'éléments trouvés : " + resultat);

		System.out.println("TABLEAU FINAL");
		System.out.println("======================================");
		printTab(tab);
	}
}
