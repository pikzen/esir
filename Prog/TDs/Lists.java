//=============================================================================
// Ex
//=============================================================================
public static void filter(List<Integer> list, int search) {
	Iterator<Integer> iter = list.iterator();

	while(t.hasNext()) {
		int val = it.next();
		if (val % search == 0) {
			it.remove();
		}
	}
}

public static<T> List<T> dedoublon(List<T> elements) {
	List<T> returned = new ArrayList<T>();
	Iterator<Integer> iter = list.iterator();

	while (iter.hasNext()) {
		int val = it.next();
		if (returned.indexOf(val) == -1) {
			returned.add(val);
		}
	}

	return returned;
}

public static void insertSorted(List<Integer> list, int val) {
	if (list.contains(val)) {
		// L'élément est déjà dans la liste.
		return;
	}

	Iterator<Integer> item = list.listIterator();
	boolean indexFound = false;
	while(iter.hasNext() && !indexFound) {
		if (it.next() > val) {
			indexFound = true;
			it.previous();
			iter.add(val)
		}
	}
}

