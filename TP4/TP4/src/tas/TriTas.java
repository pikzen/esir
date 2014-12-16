package tas;

public class TriTas {
	
	private int[] tnb;
	int p, nb;

	/**
	 * Créé un tas à partir de <code>tnb</code>
	 * MODIFIE <code>tnb</code>
	 * @param tnb Tableau à transformer en tas
	 * @param p Nombre d'élements dans le tableau.
	 */
	static void ajouterTas(int [] tnb, int p) {
		assert (p >=1 && p < tnb.length);
		/* Quand on insère, tant que p >= 1 et que le fils est plus grand on monte */
		
		int indicePere = (p-2)/2;
		
		while(indicePere >= 0){ /* Tant que l'indice du pere est < Ã  l'indice de p*/
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
	 * Supprime l'élément le plus grand du tas (à la racine), en le mettant à la fin du tableau
	 * La taille du tableau est réduite.
	 * @param tnb Tableau à modifier
	 * @param p Nombre d'éléments
	 */
	static void supprimerMax(int [] tnb, int p) {
		assert (p >1 && p <= tnb.length);
		
		// Transfert à la fin
		int tmp = tnb[0];
		tnb[0] = tnb[p-1];
		tnb[p-1] = tmp;
		
		// On doit maintenant regenerer le tas, il n'est plus forcément trié
		ajouterTas(tnb, p-1);
		
	}
	
	/**
	 * Trie un tas
	 * @param tnb Tas à trier
	 * @param nb Nombre d'éléments dans le tas.
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
