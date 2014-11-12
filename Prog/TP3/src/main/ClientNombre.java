package main;

import java.util.Scanner;
import tableau.Array;

public class ClientNombre {


	
	public static int saisie(){
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}
	

	public static boolean estPremier(int n, Array<Integer> tableauPrems) {
		
		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}
		
		for(int compteur = 0; compteur <= tableauPrems.length(); compteur++){
			if(n%tableauPrems.get(compteur) == 0){ /* si le chiffre est premier avec le contenu du tableau à l'indice : compteur */
				return false; /* On retourne faux */ 
			}
		}
		return true;
	}  
	
	
	
	public static void calculerNombresPremiers(int N, Array<Integer> tableauPremiers){
		
		estPremier(N, tableauPremiers);
		
		
		
		
		
	}
	
	
	public static void main(String[] args){
		int n = saisie();
		
		
	}
}
