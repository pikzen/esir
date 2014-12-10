package tas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientProgram {

	
	public static String Saisie(){
		Scanner entree = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du fichier de données\n");
		String fichier = entree.nextLine();
		return fichier;
	}
	
	public static void readFile() throws IOException{
		String file = Saisie();
		int nbLignes = 0;
		InputStream ips = new FileInputStream(file);
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;

		while((ligne=br.readLine())!=null){
			System.out.println(ligne);
			nbLignes++;
		}
		br.close();
	}
	
	public static int[] initTab(int nombre){
		int[] tableau = new int[nombre];
		
		return tableau;
	}
	
	public static void main(String[] args){
		
		int[] tableau = new int[] {5, 9, 4, 63, 8, 7, 12, 75, 62, 15};
		for(int i = 0; i < tableau.length; i++){
			System.out.print(tableau[i]+" ");
		}
		TriTas.ajouterTas(tableau, 10);
		System.out.println();
		for(int i = 0; i < tableau.length; i++){
			System.out.print(tableau[i]+" ");
		}
	}
	
}
