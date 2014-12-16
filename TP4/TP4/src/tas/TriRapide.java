package tas;


public class TriRapide {
	/**
	 * Partage un tableau en deux sous tableau autour d'un pivot. Les valeurs inf�rieures au pivot sont a sa 
	 * gauche, les sup�rieures a droite
	 * @param tab Tableau a trier
	 * @param binf Borne inf�rieure (index minimal)
	 * @param bsup Bornse sup�rieure (index maximal)
	 * @return Index du pivot
	 */
	static int partage(int[] tab, int binf, int bsup) {
		int left, right;
		int pivot_item = tab[binf];
		int pivot = left = binf;
		right = bsup;
		while ( left < right ) {
			// On trouve un plus grand � gauche
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
	 * @param binf Borne inf�rieure
	 * @param bsup Borne sup�rieure
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
	 * Trie un tableau <code>tab</code> de <code>nb</code> �l�ments
	 * @param tab Tableau � trier
	 * @param nb Nombre d'�l�ments
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
