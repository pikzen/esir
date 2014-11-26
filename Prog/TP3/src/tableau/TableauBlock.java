package tableau;

import types.Array;
/**
* Tableau redimensionnable, implémenté via un Array<T>
*/
public class TableauBlock<T> implements Tableau<T> {
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
	private Array<Block<T>> Elements;

	private int BlockSize;

	private int findBlock(int idx) {
		int pos = 0;

		while (idx - BlockSize > BlockSize) {
			pos++;
			idx -= BlockSize;
		}

		return pos;
	}

	private int findPos(int idx) {
		return idx - (idx * findBlock(idx));
	}

	public TableauBlock(int maxSize) {
		this(maxSize, 128);
	}

	/**
	* Construit un nouveau tableau de capacité maximale <code>capacite</code>
	* @param capacite Capacité maximale du tableau
	*/
	public TableauBlock(int maxSize, int capaciteBlock) {
			assert (maxSize > 0) : "MaxSize should be > 0, MaxSize is :" + maxSize;

			BlockSize = capaciteBlock;
			MaximumSize = maxSize;

			Elements = new Array(findBlock(MaximumSize) + 1);
			for (int i = 0; i < Elements.length(); i++) {
				Elements.set(i, new Block<T>(BlockSize));
			}
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

		return this.Elements.get(findBlock(i)).get(findPos(i));
	}

	/**
	* Modifie l'élément à l'indice i
	* @param i Index de l'élément à modifier
	* @pre 0 <= i < this.size()
	* @param elem Nouvelle valeur de l'élément
	*/
	public void set(int i, T elem) {
		assert i >= 0 && i < this.size() : "i is " + i + ", size is " + this.size();

		this.Elements.get(findBlock(i)).set(findPos(i), elem);
	}

	/**
	* Ajoute un élément en fin de tableau
	* @param elem Element à ajouter
	* @pre !this.full()
	*/
	public void push_back(T elem) {
		assert !this.full();

		this.Size++;
		if (this.full()) {
			System.out.println("==============================\n\n\n\n\n");
			System.out.println("ELEMENTS HAS " + Elements.length());
			this.resize();
			System.out.println("RESIZED HAS " + Elements.length());
		}
		this.Elements.get(Elements.length() - 1).push_back(elem);
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
	* Rajoute un block à la fin
	*/
	private void resize() {
		this.MaximumSize += BlockSize;

		Array<Block<T>> newArray = new Array(Elements.length() + 1);
		for (int i = 0; i < newArray.length() - 2; i++) {
			newArray.set(i, Elements.get(i));
		}
		newArray.set(newArray.length() -1 , new Block<T>(BlockSize));

		this.Elements = newArray;
	}
}
