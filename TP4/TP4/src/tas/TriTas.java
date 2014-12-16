package tas;

public class TriTas {
	
	private int[] tnb;
	int p, nb;

	/**
	 * Cr�� un tas � partir de <code>tnb</code>
	 * MODIFIE <code>tnb</code>
	 * @param tnb Tableau � transformer en tas
	 * @param p Nombre d'�lements dans le tableau.
	 */
	static void ajouterTas(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
		/* Quand on ins�re, tant que p >= 1 et que le fils est plus grand on monte */
		
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
	
	/**
	 * Supprime l'�l�ment le plus grand du tas (� la racine), en le mettant � la fin du tableau
	 * La taille du tableau est r�duite.
	 * @param tnb Tableau � modifier
	 * @param p Nombre d'�l�ments
	 */
	static void supprimerMax(int [] tnb, int p) {
		assert (p >1 && p <= tnb.length);
		
		// Transfert � la fin
		int tmp = tnb[0];
		tnb[0] = tnb[p-1];
		tnb[p-1] = tmp;
		
		// On doit maintenant regenerer le tas, il n'est plus forc�ment tri�
		ajouterTas(tnb, p-1);
		
	}
	
	/**
	 * Trie un tas
	 * @param tnb Tas � trier
	 * @param nb Nombre d'�l�ments dans le tas.
	 */
	public static void trier(int [] tnb, int nb) {
		assert (nb >= 1 && nb <= tnb.length);
		TriTas.ajouterTas(tnb, nb);
		
		int tabSize = nb;
		while (tabSize > 0) {
			TriTas.supprimerMax(tnb, tabSize);
			tabSize--;
		}
	}
	
	
	
}
