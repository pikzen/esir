package tas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import outilsTris.OutilsTris;

public class ClientProgram {


	/**
	 * Demande à l'utilisateur d'entrée la location du fichier de données
	 * @return Entrée de l'utilisateur
	 */
	public static String saisie(){
		Scanner entree = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du fichier de donnÃ©es\n");
		String fichier = entree.nextLine();
		return fichier;
	}

	/**
	 * Affiche un tableau dans la console
	 * @param tab Tableau à afficher
	 */
	public static void printTab(int[] tab) {
		for(int i = 0; i < tab.length; i++){
			System.out.print(tab[i]+" ");
		}
		System.out.println();
	}
	
	/**
	 * Trie un tableau, vérifie qu'il est bien égal à la solution donnée et l'enregistre dans un fichier.
	 * @param input Fichier contenant les nombres à lire
	 */
	private static void sortTab(String input) {
		int[] tab = OutilsTris.lireTableau(input)	;
		int[] valid = OutilsTris.lireTableau(input + "_trie");
		long startTime = OutilsTris.getInstantPresent();
		
		// Tri du tableau
		TriTas.trier(tab, tab.length);
		
		long endTime = OutilsTris.getInstantPresent();
		long delta = endTime - startTime;
		System.out.println("Le tri a été effectué en " + delta + " millisecondes (" + (double)delta/1000 + " secondes)");
		
		// On vérifie que le tableau est bien trié
		if (areTabsEqual(tab, valid, tab.length, valid.length)) {
			System.out.println("[OK] Les deux tableaux sont les mêmes.");
			System.out.println("Tableau trié enregistré dans " + input + "_sorted");
			OutilsTris.enregistrerTableau(tab, tab.length, input + "_sorted");
		}
		else {
			System.out.println("[ERR] Les deux tableaux sont différents.");
			printTab(tab);
			System.out.println("===============================================================");
			printTab(valid);
		}
	}
	
	private static void quicksortTab(String input) {
		int[] tab = OutilsTris.lireTableau(input)	;
		int[] valid = OutilsTris.lireTableau(input + "_trie");
		
		long startTime = OutilsTris.getInstantPresent();
		
		System.out.println("Quicksorting");
		// Tri du tableau
		TriRapide.trier(tab, tab.length);
		
		long endTime = OutilsTris.getInstantPresent();
		long delta = endTime - startTime;
		System.out.println("Le tri a été effectué en " + delta + " millisecondes (" + (double)delta/1000 + " secondes)");
		// On vérifie que le tableau est bien trié
		if (areTabsEqual(tab, valid, tab.length, valid.length)) {
			System.out.println("[OK] Les deux tableaux sont les mêmes.");
			System.out.println("Tableau trié enregistré dans " + input + "_sorted");
			OutilsTris.enregistrerTableau(tab, tab.length, input + "_sorted");
		}
		else {
			System.out.println("[ERR] Les deux tableaux sont différents.");
			printTab(tab);
			System.out.println("===============================================================");
			printTab(valid);
		}
	}

	public static void main(String[] args){
		System.out.println("===================================================");
		System.out.println("===         Tri par tas (heapsort)               ==");
		System.out.println("===================================================");
		//sortTab(saisie());
		
		
		System.out.println("===================================================");
		System.out.println("===         Tri rapide (quicksort)               ==");
		System.out.println("===================================================");
		quicksortTab(saisie());
		/**System.out.println("Tri de 97 éléments");
		sortTab("D:/Code/ESIR/TP4/src/tas/donnees_00097");
		
		System.out.println("Tri de 1290 éléments");
		sortTab("D:/Code/ESIR/TP4/src/tas/donnees_01290");
		
		System.out.println("Tri de 50000 données");
		sortTab("D:/Code/ESIR/TP4/src/tas/donnees_50000");
		*/
	}
	
	/**
	 * Vérifie si deux tableaux sont égaux
	 * @param first Premier tableau
	 * @param second Deuxieme tableau
	 * @param nbFirst Nombre d'éléments du premier tableau
	 * @param nbSecond Nombre d'éléments du deuxieme tableau
	 * @return true si les tableaux sont égaux, false sinon
	 */
	private static boolean areTabsEqual(int[] first, int[] second, int nbFirst, int nbSecond) {
		if (nbFirst != nbSecond) return false;
		
		for (int i = 0; i < nbFirst; i++) {
			if (first[i] != second[i]) return false;
		}
		
		return true;
	}

}
