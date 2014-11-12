package tableau;

public class Array<T> {

	private Object[] tabElem;

	public Array(int capacite) {
		this.tabElem = new Object[capacite];
	}

	public int length() {
		return tabElem.length;
	}

	public T get(int i) {
		@SuppressWarnings("unchecked")
		final T e = (T) tabElem[i];
		return e;
	}

	public void set(int i, T v) {
		tabElem[i] = (Object) v;
	}

}
