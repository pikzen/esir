package esir.tp2;
package rationnel;


import java.util.ArrayList;
import java.util.Scanner;

public class TRationnel {
	public static void main(String[] args) {
		int num, den;
		Scanner entree = new Scanner(System.in);
		
		System.out.println("Entrez le numérateur : \n");
		num = entree.nextInt();
		System.out.println("Entrez le dénominateur : \n");
		den = entree.nextInt();
		int cpt = 0;
		
		ArrayList<Rationnel> listRat = new ArrayList<Rationnel>();

		
		Rationnel r1 = new RationnelSimple(num, den);
		
		while(r1.getDenominateur() != 0  && r1.getNumerateur() != 0){
			
			listRat.add(cpt, r1);
			System.out.println("Entrez le numérateur : \n");
			num = entree.nextInt();
			System.out.println("Entrez le dénominateur : \n");
			den = entree.nextInt();
			r1 = new RationnelSimple(num, den);
			cpt++;
			
		}


		for(int compteur = 0; compteur < listRat.size(); compteur++){
		System.out.println("Rationnel : " + listRat.get(compteur));
		if(compteur == 0){
			System.out.println("Somme : 0");
		}else{
			System.out.println("Somme : " +listRat.get(compteur).somme(listRat.get(compteur-1)));
		}
		System.out.println("Réel : " + listRat.get(compteur).valeur());
		System.out.println("Inverse : " + listRat.get(compteur).inverse());
		if(compteur != 0){
			
		System.out.println("Compare to : "+listRat.get(compteur).compareTo(listRat.get(compteur-1)));
		System.out.println("Egal : "+listRat.get(compteur).equals(listRat.get(compteur-1)));
		}else{
			System.out.println("Impossible de procéder au compare to, manque précédent\n\n");
		}
		
			
		}
	}
}
