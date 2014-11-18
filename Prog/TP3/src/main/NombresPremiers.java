package main;

import java.util.Random;
import java.util.Scanner;

import tableau.Block;
import tableau.Tableau;

public class NombresPremiers {

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
		int lastInt = 2; /* Dernier entier testé */
		
		for (int i = 2; tableauPremier.size() < 100 && i <= N; i++) { /* Tant que i < taille du tableau et <= à N */
			lastInt = i; /* On met à jour le dernier entier testé */
			if (!estPremier(i, tableauPremier)) { /* Si l'entier n'est pas premier */
				boolean isPrime = true; /* Déclaration de la variable isPrime */
				for (int j = 0; j < tableauPremier.size(); j++) { /* Pour chaque élément de tableauPremier */
					if (i % tableauPremier.get(j) == 0) { /* Si l'élément testé n'est pas premier on met isPrime à false et on quitte la boucle */
						isPrime = false;
						break;
					}
				}
				
				if (isPrime) tableauPremier.push_back(i); /* Si i est premier on le push_back dans le tableauPremier */
			}
		}
		
		return lastInt;
		
	}

	public static Block<Integer> remplirHasard(int nb) {
		Block<Integer> newTableau = new Block<Integer>(nb); /* Le tableau newTableau de capacité nb qu'on doit retourner */
		
		Random r1 = new Random(); /* Sert à choisir un chiffre au hasard */

		for (int i = 0; i < nb; i++) { /* Pour i jusqu'à nb-1 */

			int nombre = (r1.nextInt(nb)); /* Je fais un random sur nb */
			newTableau.push_back(nombre); /* Je le mets dans le tableau */

		}
		
		return newTableau; /* Je retourne le tableau */
	}

	public static void eliminerPresents(Block<Integer> tab1, Block<Integer> tab2) {
		
		int nbElementsSupprimes = 0;
		Block<Integer> tabFinal = new Block<Integer>(tab1.size());
		int g = 0;
		
		for(int i = 0; i < tab1.size(); i++){ /* Parcourir chaque élément du tableau ou on supprime */
			
			for(int j = 0; j < tab2.size(); j++){ /* Parcourir tout les éléments du tableau 2*/
				
				if(tab1.get(i) == tab2.get(j)){ /* Si un élément t1 == un élement de t2 */
					tabFinal.push_back(tab1.get(i));
					nbElementsSupprimes++; /* On incrémente la variable des éléments à supprimer */
					break; /* On sort de la boucle */
				}
			}
		}
		
		for(int f = 0; f < nbElementsSupprimes; f++){
			tabFinal.pop_back();
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
