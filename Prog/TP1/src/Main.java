package esir.tp1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	static int MAX_ARRAY_SIZE = 15;
	public static void main(String[] args) throws Exception {
		//int[] tableau = new int[Main.MAX_ARRAY_SIZE];
		//int[] tableau2=new int[Main.MAX_ARRAY_SIZE];

		int[] tableau = new int[] { 42, 43, 44, 45, 46, 47, 48};
		int elements = tableau.length;
		//Main.afficherTableau(tableau, 6);
		Scanner sc = new Scanner(System.in);

		//int elements = Main.lireTableau(tableau, sc);
		//System.out.println(elements + " éléments insérés dans le tableau");
		//int elements2=Main.lireTableau(tableau2, sc);

		Main.afficherTableau(tableau, elements);

		Main.insertionSort(tableau, elements);
		//Main.insertionSort(tableau2, elements2);

		Main.afficherTableau(tableau, elements);
		//Main.afficherTableau(tableau2, elements2);

		//int[] interTab = Main.interclassementTableaux(tableau, tableau2, elements, elements2);
		//Main.afficherTableau(interTab, interTab.length);

		System.out.println("===================================================");
		System.out.println("= Recherche dichotomique");
		System.out.println("===================================================");
		int found = Main.dichotoSearch(42, tableau, elements);

		if (found == -1) {
			System.out.println(("La valeur n'est pas présente dans le tableau"));
		}
		else {
			System.out.println("La valeur est présente à l'index :" + found);
		}


	}

	/**
	* Initialise un tableau avec les valeurs d'une suite de nombres entiers lus au clavier
	* Le remplissage du tableau est arreté quand la valeur -1 est entrée.
	*
	* @param tnb Tableau de nombres
	* @param entree Scanner d'entree ou se fait la lecture
	* @return Nombre d'entiers saisis
	*
	* @post Le tableau contient bien N nombres entiers
	*/
	public static int lireTableau(int[] tnb, Scanner entree) throws Exception{
		int elementsInArray = 0;
		int input = 0;
		System.out.println("Remplissage du tableau (-1 pour arrêter): ");
		do {
			System.out.print("> ");
			// Récupération de la valeur entrée
			// On vérifie si le prochain token est bien un entier. Si non, on ignore l'intégralité de la ligne, et on attend le prochain element
			if (entree.hasNextInt()) {
				input = entree.nextInt();
				// Si on dépasse la taille du tableau, on arrête d'inserer des éléments.
				if (elementsInArray == Main.MAX_ARRAY_SIZE) {
					return elementsInArray;
				}

				// On n'insère pas -1 dans le tableau.
				if (input != -1) {
					tnb[elementsInArray]  = input;
					elementsInArray++;
				}
			}
			else {
				// Pas d'entier dans l'entrée, on ignore.
				entree.next();
			}
		}
		while (input != -1);

		return elementsInArray;
	}

	/**
	* Affiche les <i>nb</i> premiers éléments d'un tableau
	*
	* @param tnb Tableau de nombres (initialisé)
	* @param nb   Nombre d'éléments à afficher
	*
	* @pre Verifie que nb n'est pas superieur à tnb.length;
	* @post Le tableau n'est pas modifié
	*/
	public static void  afficherTableau(int[] tnb, int nb) throws Exception{
		if (nb > tnb.length || nb < 0) {
			throw new Exception("Impossible d'afficher plus d'éléments qu'il n'y en a");
		}

		System.out.println("Tableau: ");
		System.out.print("[");
		for (int i = 0; i < nb; i++) {
			// Ne pas inserer de virgules avant le premier element du tableau
			if (i != 0) {
				System.out.print(", ");
			}

			System.out.print(tnb[i]);
		}
		System.out.println("]");
	}

	/**
	* Applique un tri par insertion sur <i>tab</i>
	*
	* @param tab Tableau à trier
	*/
	public static void insertionSort(int[] tab, int numElements) {
		 // On itère sur les éléments non triès. (On considère que l'élément à l'index 0 est déjà trié et le sera lorsqu'on inserera les autres éléments)
		 // On trouve la position à laquelle inserer l'élément actuelle.

		 for (int unsortedElements = 1; unsortedElements < numElements; unsortedElements++) {
		 	int j = unsortedElements;
		 	while (j > 0  && tab[j - 1] > tab[j]) {
		 		int temp = tab[j];
		 		tab[j] = tab[j-1];
		 		tab[j-1] = temp;
		 		j = j-1;
		 	}
		 }
	}

	/**
	* En passant deux tableaux en paramètre, créé un troisieme tableau contenant les valeurs de ces deux tableaux, triées.
	*
	* @param tab1 Premier Tableau
	* @param tab2 Deuxieme Tableau
	* @Param numTab1 Nombre d'éléments dans le premier tableau
	* @param numTab2 Nombre d'éléments dans le deuxième tableau
	*
	* @return Nouveau tableau contenant les deux autres tableaux, trié.
	*/
	public static int[] interclassementTableaux(int[] tab1, int[] tab2, int numTab1, int numTab2) {
		int[] finalTab = new int[numTab1 + numTab2];
		int tab1Pos = 0, tab2Pos = 0, k = 0;

		// On compare les deux tableaux jusqu'a ce qu'on ait comparé le maximum d'éléments possibles.
		while (tab1Pos < numTab1 && tab2Pos < numTab2) {
			if (tab1[tab1Pos] < tab2[tab2Pos]) {
				finalTab[k] = tab1[tab1Pos];
				tab1Pos++;
			}
			else {
				finalTab[k] = tab2[tab2Pos];
				tab2Pos++;
			}
			k++;
		}

		// On insère le reste du premier tableau (quii est garanti d'être plus petit que ce qu'il reste dans le deuxieme tableau)
		while (tab1Pos < numTab1 ) {
			finalTab[k] = tab1[tab1Pos];
			k++; tab1Pos++;
		}

		// On insère le reste (si il y a)
		while (tab2Pos < numTab2 ) {
			finalTab[k] = tab2[tab2Pos];
			k++; tab2Pos++;
		}

		return finalTab;
	}

	public static int dichotoSearch(int value, int[] tab, int nbElems) {
		int min = 0, max = nbElems - 1, middle = 0;

		if (nbElems == 0) {
			return -1;
		}

		while (min < max) {
			middle = (min + max) / 2;
			if (tab[middle] == value) {
				return middle;
			}
			else if (tab[middle] < value) {
				min = middle + 1;
			}
			else {
				max = middle - 1;
			}
		}
		return -1;
	}
}
