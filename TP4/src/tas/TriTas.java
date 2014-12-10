package tas;

public class TriTas {
	
	private int[] tnb;
	int p, nb;

	static void ajouterTas(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
		/* Quand on insère, tant que p >= 1 et que le fils est plus grand on monte */
		
		int indicePere = (p-1)/2;
		
		while(indicePere >= 0){ /* Tant que l'indice du pere est < à l'indice de p*/
			while (indicePere * 2 + 1 <=  p - 1) {
				int enfant = indicePere*2 + 1;
				int swap = indicePere;

				if (tnb[swap] < tnb[enfant]) {
					swap = enfant;
				}
				if (enfant+1 <= p && tnb[swap] < tnb[enfant + 1]) {
					swap = enfant + 1;
				}
				if (swap == indicePere) {
					break;
				}
				else {
					int tmp = tnb[indicePere];
					tnb[indicePere] = tnb[swap];
					tnb[swap] = tmp;

					indicePere = swap;
				}
			}			
			indicePere--;
		}
	}
	
	static void supprimerMax(int [] tnb, int p) {
		assert (p >1 && p <= tnb.length);
		
		tnb[0] = tnb[p];
		
		
		/* Mettre la valeur d'indice p à la racine, checker si les fils sont plus grands, le mettre a sa place et mettre le fils le plus grand en valeurMax */
		
		
		
		
	}
	
	public static void trier(int [] tnb, int nb) {
		assert (nb >= 1 && nb <= tnb.length);
	}
	
	
	
}
