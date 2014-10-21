package rationnel;

public class Couple<T1, T2> {
	private T1 First;
	private T2 Second;

	public Couple(T1 first, T2 second) {
		this.First 	= first;
		this.Second 	= second;
	}

	public T1 getFirst() {
		return this.First;
	}

	public T2 getSecond() {
		return this.Second;
	}
}
