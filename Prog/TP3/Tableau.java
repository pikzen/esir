public interface Tableau<T> {
	public int size();

	public boolean empty();

	public boolean full();

	public T get(i);

	public void set(int i, T v);

	public void push_back(T x);

	public void pop_back();
}
