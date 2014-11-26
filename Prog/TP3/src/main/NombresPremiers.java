package main;

import java.util.Random;
import java.util.Scanner;

import tableau.Tableau;
import tableau.Block;

/**
* Implémente les méthodes relatives aux nombres premiers et autres. Voir TP.
*/
public class NombresPremiers {

	/**
	* Récupère un nombre saisi par l'utilisateur
	*/
	public static int saisie() {
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}

	/**
	* Remplit un tableau avec TOUS les nombres compris entre 2 et n
	* @param n Valeur maximale à rentrer dans le tableau
	* @param tableauRemp Le tableau dans lequel les valeurs seront inserées
	* NOTE: Modifie <code>tableauRemp</code>
	*/
	public static void setTableau(int n, Tableau<Integer> tableauRemp) {
		for (int cpt = 2; cpt <= n; cpt++) {
			tableauRemp.push_back(cpt);
		}
	}

	/**
	* Vérifie si <code>n</code> est un nombre premier en le cherchant dans
	* <code>tableauRemp</code>.
	* @param n Entier à vérifier
	* @param tableauPrems Liste de nombres premiers
	* @return <code>true</code> si <code>n</code> est premier,
	*		  <code>false</code> sinon
	*/
	public static boolean estPremier(int n, Tableau<Integer> tableauPrems) {
		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}

		// Itération sur tous les nombres présents dans tableauPrems
		// NOTE: Puisque ce tableau est trié, on pourrait utiliser une recherche
		// dichotomique
		// On essaie de prouver que le nombre n'est pas premier et une fois que
		// toutes les solutions sont épuisées, on sait qu'il est premier
		// (ou bien qu'il n'est pas dans tableauPrems)
		for (int compteur = 0; compteur < tableauPrems.size(); compteur++) {
			int val = tableauPrems.get(compteur);
			if (val == 0) {
				return false;
			}

			if (n % val == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	* Calcule les nombres premiers de 2 à <code>n</code> et les insere dans
	* <code>tableauPremier</code>
	* NOTE: modifie <code>tableauPremier</code>
	* @param n Valeur maximale pour les nombres premiers
	* @param tableauPremier Stockage des premiers
	* @return Le nombre de premiers si on à réussi à remplir le tableau
	*		  <code>n</code> sinon
	*/
	public static int calculerNombresPremiers(int n, Tableau<Integer> tableauPremier) {
		int cpt = 2;

		// Jusqu'a ce qu'on ait réussi à remplir le tableau ou bien qu'on
		// atteigne n, on teste chaque nombre successivement
		// Si il est premier, alors il ne sera pas dans tableauPremier et on
		// pourra l'ajouter. Sinon, on passe au nombre suivant
		while (!tableauPremier.full() && (cpt <= n)) {
			if (estPremier(cpt, tableauPremier)) {
				tableauPremier.push_back(cpt);
			}
			cpt++;
		}

		if (tableauPremier.full() && (cpt <= n)) {
			return cpt - 1;
		} else {
			return n;
		}
	}

	/**
	* Renvoie un tableau constitué de n nombres aléatoires
	*/
	public static Tableau<Integer> remplirHasard(int nb) {
		Block<Integer> newTableau = new Block<Integer>(nb);
		Random r1 = new Random();

		// Génération et insertion
		for (int i = 0; i < nb; i++) {
			int nombre = (r1.nextInt(nb));
			newTableau.push_back(nombre);
		}

		return newTableau;
	}

	/**
	* Applique un tri par insertion sur <code>tab</code>
	* NOTE: modifie <code>tab</code>
	* @param tab Le tableau à trier
	*/
	private static void insertionSort(Tableau<Integer> tab) {
		 // On itère sur les éléments non triès. (On considère que l'élément à
		 // l'index 0 est déjà trié et le sera lorsqu'on inserera les autres
		 // éléments)
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

	/**
	* Applique une recherche dichotomique pour trouver <code>check</code>
	* dans le tableau <code>nums</code>
	* @param check Le nombre à chercher
	* @param nums Le tableau dans lequel chercher
	* @return -1 si l'élément n'est pas présent, ou son index dans
	*		  <code>nums</code> si il l'est
	*/
	private static int rechercheDichotomique(int check, Tableau<Integer> nums ) {
	        int high = nums.size() - 1;
	        int low = 0;
	        int guess = 0;
	        while(high >= low){
                guess = low + ((high - low) / 2);
                if(nums.get(guess) > check){
                    guess = high - 1;
                }else if(nums.get(guess) < check){
                    low = guess + 1;
                }else{
                    return guess;
                }
	        }
	        return -1;
      }

    /**
    * Elimine dans <code>tab1</code> les nombres communs avec <code>tab2</code>
	* NOTE: Modifie <code>tab1</code>
    * @param tab1 Tableau ou les nombres seront supprimés
    * @param tab2 Tableau ou chercher les nombres
    * @return le nombre de nombres supprimés
    */
	public static int eliminerPresents(Tableau<Integer> tab1, Tableau<Integer> tab2) {
		Tableau<Integer> tabTmp = new Block<Integer>(tab1.size());
		// On trie le tableau pour pouvoir appliquer une recherche dichotomique
		insertionSort(tab2);
		int elementsSupprimes = 0;

		// On parcourt tout tab1 et pour chaque élément, on recherche dans tab2
		for (int i = 0; i < tab1.size(); i++) {
			if (rechercheDichotomique(tab1.get(i), tab2) == -1){
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

	/**
	* Affiche le tableau <code>t1</code> sous la forme [x y z ...]
	* @param t1 Le tableau à afficher
	*/
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
		int somme = calculerNombresPremiers(N, tab2);
		int resultat = eliminerPresents(tab, tab2);
		System.out.println("======================================");
		System.out.println("Nombre d'éléments trouvés : " + resultat);

		System.out.println("TABLEAU FINAL");
		System.out.println("======================================");
		printTab(tab);
	}
}
