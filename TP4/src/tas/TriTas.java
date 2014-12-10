package tas;

public class TriTas {
	
	private int[] tnb;
	int p, nb;

	static void ajouterTas(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
		/* Quand on insère, tant que p >= 1 et que le fils est plus grand on monte */
		
		int indicePere = (p-2)/2;
		
		while(indicePere >= 0){ /* Tant que l'indice du pere est < à l'indice de p*/
			while (indicePere * 2 + 1 <=  p - 1) {
				int enfant = indicePere*2 + 1;
				int swap = indicePere;

				if (tnb[swap] < tnb[enfant]) {
					swap = enfant;
				}
				if (enfant+1 <= p - 1 && tnb[swap] < tnb[enfant + 1]) {
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
		
		int tmp = tnb[0];
		tnb[0] = tnb[p-1];
		tnb[p-1] = tmp;
		
		int index = 0;
		int lower = tnb[0];
		int lowerIndex = 0;
		while(tnb[2*index+1] > tnb[index] || 
			   tnb[2*index+2] > tnb[index]){

			if(tnb[2*index+1] > tnb[index]){
				lower = tnb[2*index+1];
				lowerIndex = 2*index+1;
			}
			
			if(tnb[2*index+2] > tnb[index]){
				if(tnb[2*index+2] > lower){
					lower = tnb[2*index+2];
					lowerIndex = 2*index+2;
				}
			}
			
			int tempLow = tnb[index];
			tnb[index] = tnb[lowerIndex];
			tnb[lowerIndex] = tempLow;
			
			if (index == lowerIndex) {
				break;
			}
			
			index = lowerIndex;
			if (2*index + 1 > p-2 || 2*index+2 > p-2) {
				System.out.println("Ca dépasse");
				return;
			}
			System.out.println("Index is " + index);
		}
		
	}
	
	public static void trier(int [] tnb, int nb) {
		assert (nb >= 1 && nb <= tnb.length);
		TriTas.ajouterTas(tnb, nb);
		
		int tabSize = nb;
		while (tabSize > 0) {
			System.out.println("Restant a trier : " + tabSize);
			TriTas.supprimerMax(tnb, tabSize);
			tabSize--;
		}
	}
	
	
	
}
