package tas;


public class TriRapide {
	/**
	 * Partage un tableau en deux sous tableau autour d'un pivot. Les valeurs inférieures au pivot sont a sa 
	 * gauche, les supérieures a droite
	 * @param tab Tableau a trier
	 * @param binf Borne inférieure (index minimal)
	 * @param bsup Bornse supérieure (index maximal)
	 * @return Index du pivot
	 */
	static int partage(int[] tab, int binf, int bsup) {
		int left, right;
		int pivot_item = tab[binf];
		int pivot = left = binf;
		right = bsup;
		while ( left < right ) {
			// On trouve un plus grand à gauche
			while( tab[left] <= pivot_item && left < bsup) left++;
			// On trouve un plus petit a droite
			while( tab[right] > pivot_item && right > binf) right--;
			if ( left < right ){
				swap(tab,left,right);
			}
		}
		// On remet le pivot a sa position
		tab[binf] = tab[right];
		tab[right] = pivot_item;
		return right;
	}

	/**
	 * Effectue un quicksort sur <code>tab</code>
	 * MODIFIE le tableau
	 * @param tab Tableau a trier
	 * @param binf Borne inférieure
	 * @param bsup Borne supérieure
	 */
	static void triRapide(int[] tab, int binf, int bsup) {
		if (binf < bsup) {
			int pos = partage(tab, binf, bsup);
			if (binf < pos - 1)
				triRapide(tab, binf, pos-1);
			if (pos < bsup)
				triRapide(tab, pos + 1, bsup);
		}
	}
	
	/**
	 * Trie un tableau <code>tab</code> de <code>nb</code> éléments
	 * @param tab Tableau à trier
	 * @param nb Nombre d'éléments
	 */
	public static void trier(int[] tab, int nb) {
		triRapide(tab, 0, tab.length - 1);
	}


	/**
	 * Inverse deux valeurs dans un tableau
	 */
	private static void swap(int[] tab, int first, int second) {
		int tmp = tab[first];
		tab[first] = tab[second];
		tab[second] = tmp;
	}
}
