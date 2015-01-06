package tableau;

import types.Array;
/**
* Tableau redimensionnable, implémenté via un Array<T>
*/
public class Tableau2x<T> implements Tableau<T> {
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
	public Tableau2x(int cap) {
		assert (cap > 0);

		this.MaximumSize = cap;
		this.Elements = new Array<T>(this.MaximumSize);
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
		assert i >= 0 && i < this.size();

		return this.Elements.get(i);
	}

	/**
	* Modifie l'élément à l'indice i
	* @param i Index de l'élément à modifier
	* @pre 0 <= i < this.size()
	* @param elem Nouvelle valeur de l'élément
	*/
	public void set(int i, T elem) {
		assert i >= 0 && i < this.size();

		this.Elements.set(i, elem);
	}

	/**
	* Ajoute un élément en fin de tableau
	* @param elem Element à ajouter
	* @pre !this.full()
	*/
	public void push_back(T elem) {
		assert !this.full();

		this.Elements.set(Size, elem);
		this.Size++;

		if (this.full()) {
			this.resize();
		}
	}

	/**
	* Supprime le dernier élément du tableau
	* @pre !this.empty()
	*/
	public void pop_back() {
		assert !this.empty();

		this.Size--;
	}

	/**
	* Redimensionne le tableau stockant les données
	* Double sa taille
	*/
	private void resize() {
		this.MaximumSize *= 2;
		Array<T> newElem = new Array<T>(this.MaximumSize);

		int len = this.Elements.length();
		for (int i = 0; i < len; i++) {
			newElem.set(i, this.Elements.get(i));
		}
		this.Elements = newElem;
	}
}
