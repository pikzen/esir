package main;

import java.util.Scanner;
import tableau.Array;

public class ClientNombre {


	
	public static int saisie(){
		int nombreSaisi;
		Scanner sc = new Scanner(System.in);
		return nombreSaisi = sc.nextInt();

	}
	

	public static boolean estPremier(int n){
		int compteur;
		int test = 1;

		  for (compteur = 2; compteur < n; compteur++)
		    if (n % compteur == 0)
		      test = 0;
		  if (test == 1){
		    System.out.println(n+" est un nombre premier");
		    return true;
		  }else{
			  System.out.println(n+" n'est pas un nombre premier");
			  return false;
		  }
	}
	
	
	public static void calculerNombresPremiers(int N, Array<Integer> tableau){
		
	}
	
	
	public static void main(String[] args){
		int n = saisie();
		estPremier(n);
		
	}
}
