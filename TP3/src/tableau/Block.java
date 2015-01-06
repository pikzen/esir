package tableau;

import types.Array;
/**
* Tableau redimensionnable, implémenté via un Array<T>
*/
public class Block<T> implements Tableau<T> {
	/**
	* Taille actuelle du tableau
	*/
	private int Size = 0;

	/**
	* Taille maximale du tableau
	*/
	private int MaximumSize = 0;

	/**
	* Elements actuels dans le tableau
	*/
	private Array<T> Elements;

	/**
	* Construit un nouveau tableau de capacité maximale <code>capacite</code>
	* @param capacite Capacité maximale du tableau
	*/
	public Block(int capacite) {
		assert (capacite > 0);
		this.MaximumSize = capacite;
		this.Elements = new Array<T>(capacite);
	}

	/**
	* Taille actuelle du tableau
	*/
	public int size() {
		return this.Size;
	}

	/**
	* Ce tableau est-il vide ?
	* @return <code>true</code> si le tableau est vide, <code>false</code> sinon
	*/
	public boolean empty() {
		return this.Size == 0;
	}

	/**
	* Ce tableau est-il plein ?
	* @return <code>true</code> si le tableau est plein, <code>false</code> sinon
	*/
	public boolean full() {
		return this.Size == this.MaximumSize;
	}

	/**
	* Renvoye l'élément à l'indice i
	* @param i Index de l'élément
	* @pre 0 <= i < this.size()
	* @return Valeur de l'élément à l'indice i
	*/
	public T get(int i) {
		assert i >= 0 && i < this.size() : "i is " + i + ", size is " + Size;

		return this.Elements.get(i);
	}

	/**
	* Modifie l'élément à l'indice i
	* @param i Index de l'élément à modifier
	* @pre 0 <= i < this.size()
	* @param elem Nouvelle valeur de l'élément
	*/
	public void set(int i, T elem) {
		assert i >= 0 && i < this.size() : "i is " + i + ", size is " + Size;

		this.Elements.set(i, elem);
	}

	/**
	* Ajoute un élément en fin de tableau
	* @param elem Element à ajouter
	* @pre !this.full()
	*/
	public void push_back(T elem) {
		assert !this.full();

		this.Size++;
		this.Elements.set(Size - 1, elem);
	}

	/**
	* Supprime le dernier élément du tableau
	* @pre !this.empty()
	*/
	public void pop_back() {
		assert !this.empty();

		this.Size--;
	}
}
