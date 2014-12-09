package MangeMaTeub;

public class TriTas {
	
	private int[] tnb;
	int p, nb;

	static void ajouterTas(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
		/* Quand on insère, tant que p >= 1 et que le fils est plus grand on monte */
		
		int indicePere = (p-1)/2;
		
		while(p >= 1 && tnb[indicePere]<tnb[p]){ /* Tant que l'indice du pere est < à l'indice de p*/
		
			int temp = tnb[p]; /* Wllh j'crois que ça marche */
			tnb[p] = tnb [indicePere]; 
			tnb[indicePere] = temp;
			p = indicePere;
		}
	}
	
	static void supprimerMax(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
	}
	
	public static void trier(int [] tnb, int nb) {
		assert (nb >= 1 && nb < tnb.length);
	}
	
	
	
}
