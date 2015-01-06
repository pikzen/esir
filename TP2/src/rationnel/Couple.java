package rationnel;

/**
 * Représente un couple de deux éléments de type quelconque. 
 */

public class Couple<T1, T2> { 
	private T1 First;
	private T2 Second;

	public Couple(T1 first, T2 second) {
		this.First = first;
		this.Second = second;
	}

// ===================================================================
// GETTERS
// ===================================================================
	
	public T1 getFirst() {
		return this.First;
	}

	public T2 getSecond() {
		return this.Second;
	}
}