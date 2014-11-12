public static boolean divisibleParTrois(List<Integer> entier) {
	// Somme des chiffres
	Iterator<Integer> iter = entier.iterator();
	int sum = 0;
	while (iter.hasNext()) {
		sum  += it.next();
	}

	return sum % 3 == 0;
}
//==============================================================================
//==============================================================================
//==============================================================================
public static boolean isEqual(List<Integer> first, List<Integer> second) {
	if (first.size() != second.size()) {
		return false;
	}

	Iterator<Integer> iterFirst = first.listIterator();
	Iterator<Integer> iterSecond = second.listIterator();

	while (iterFirst.hasNext()) {
		if (iterFirst.next() != iterSecond.next()) {
			return false;
		}
	}

	return true;
}
//==============================================================================
//==============================================================================
//==============================================================================
public static List<Integer> sum(List<Integer> first, List<Integer> second) {
	Iterator<Integer> iterFirst = first.listIterator();
	Iterator<Integer> iterSecond = second.listIterator();

	/* On amene les deux itérateurs à la fin de la liste
	 * On additionne les éléments les plus faibles, en ajoutant la retour du
	 * précédent (si il y a)
	 */
	while (iterFirst.hasNext()) iterFirst.next();
	while (iterSecond.hasNext()) iterSecond.next();
	List<Integer> elements = new ArrayList<Integer>();
	int carry = 0;

	while (iterFirst.previousIndex() != -1 &&
		   iterSecond.previousIndex() != -1) {
		// Calcul de la somme des deux, plus le carry du précédent
		// recalcul du carry ensuite
		int sum = iterFirst.previous() + iterSecond.previous() + carry;
		if (sum >= 10) {
			sum -= 10;
			carry = 1;
		}
		else {
			carry = 0;
		}

		elements.add(0, sum);
	}

	Iterator<Integer> target = iterFirst.previousIndex() != -1 ? iterFirst : iterSecond;

	while (target.previousIndex() != -1) {
		elements.add(0, target.previous());
	}

	return elements;

	/*
	     10 050 100 301 102
   	+85 091 489 785 125 651
    =======================
     85 101 539 885 426 753
    c   1    1
    */
}
