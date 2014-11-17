package main;

import java.util.Scanner;
import tableau.Block;

public class ClientNombre {


	
	public static int saisie(){
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}
	

public static boolean estPremier(int n, Block<Integer> tableauPrems) {
		
		if (n < 0) { /* Si nombre négatif pas de nombre premier */
			return false;
		}
		
		for(int compteur = 0; compteur <= tableauPrems.size(); compteur++){
			if(n%tableauPrems.get(compteur) == 0){ /* si le chiffre est premier avec le contenu du tableau à l'indice : compteur */
				return false; /* On retourne faux */ 		
			}
		}
		return true;
	}  
	
	
	static int calculerNombrePremiers(int N, Block<Integer> tableauPremier)
	{
		int cpt = 0;
		int g = 0;
		
		while (!tableauPremier.full() && (cpt <= N)){
			
			if (estPremier(cpt, tableauPremier)){
			
				tableauPremier.set(g, cpt);
				g++;
			}
			
			cpt++;
		}
		
		if (tableauPremier.full() && (cpt <= N)){
			return cpt-1;	
		}else{
			return N;
		}
	}
	
	
	public static void remplirHasard(int nb){
		Block<Integer> tableau = new Block<Integer>(nb);
		
	}
	
	
	public static void eliminerPresents(Block<Integer> tab1, Block<Integer> tab2){
		
	}
	
	public static void main(String[] args){
		Block<Integer> tab = new Block<Integer>(100);
		System.out.println("Entrez un nombre N");
		int N = saisie();
		int resultat = calculerNombrePremiers(N, tab);
		System.out.println(resultat);
	}
}
