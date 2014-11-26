package tableau;

import types.Array;
/**
* Tableau redimensionnable
* Ce tableau se redimensionnera automatiquement lorsque sa taille maximale est
* atteinte, en augmentant sa capacité de <code>BlockSize</code>
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

	/**
	* Taille d'un block du tableau
	*/
	private int BlockSize;

	/**
	* Trouve l'index du block dans lequel sera présent l'élément à l'index
	* <code>idx</code>
	* @param idx Index de l'élément
	*/
	private int findBlock(int idx) {
		// Pour les opérations get, set, push_back et pop_back, cet index
		// sera nécessaire. Plutot que de réécrire la formule à chaque fois,
		// findBlock() nous permettra de la réutiliser facilement
		return idx / BlockSize;
	}

	/**
	* Trouve l'index dans le Block ou sera présent l'élément à l'index
	* <code>idx</code>
	* @param idx Index de l'élément
	*/
	private int findPos(int idx) {
		// Même raisons que findBlock(), simplifie l'écriture des algorithmes
		// Dans ce cas, on soustrait juste à l'index l'index minimal de son bloc
		return idx - (BlockSize * findBlock(idx));
	}

	/**
	* Construit un nouveau tableau de capacité <code>maxSize</code>
	* Les Block le composant ont une capacité de 128 éléments
	*/
	public TableauBlock(int maxSize) {
		this(maxSize, 128);
	}

	/**
	* Construit un nouveau tableau de capacité maximale <code>maxSize</code> et
	* de capacité de block <code>capaciteBlock</code>
	* @param capacite Capacité maximale du tableau
	*/
	public TableauBlock(int maxSize, int capaciteBlock) {
			assert (maxSize > 0);

			BlockSize = capaciteBlock;
			MaximumSize = maxSize;

			// Initialisation des Blocks nécessaires pour contenir maxSize
			// éléments.
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
		assert i >= 0 && i < this.Size;

		return this.Elements.get(findBlock(i)).get(findPos(i));
	}

	/**
	* Modifie l'élément à l'indice i
	* @param i Index de l'élément à modifier
	* @pre 0 <= i < this.size()
	* @param elem Nouvelle valeur de l'élément
	*/
	public void set(int i, T elem) {
		assert i >= 0 && i < this.size();

		this.Elements.get(findBlock(i)).set(findPos(i), elem);
	}

	/**
	* Ajoute un élément en fin de tableau, et redimensionne le tableau si
	* nécéssaire
	* @param elem Element à ajouter
	* @pre !this.full()
	*/
	public void push_back(T elem) {
		assert !this.full();

		// On ajoute l'élément puis on redimensionne si besoin
		// Ainsi le tableau sera toujours disponible
		this.Elements.get(findBlock(Size)).push_back(elem);
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
	* Rajoute un block à la fin
	* NOTE: Ne réduit pas le nombre de blocks. Si le nombre de blocks est plus
	* grand que le nombre de blocks nécessaire, ils ne seront pas supprimés
	*/
	private void resize() {
		this.MaximumSize += BlockSize;

		// Création d'un nouvel Array, on remplit avec les données actuelles
		// Puis on ajoute un Block vide à la fin
		Array<Block<T>> newArray = new Array<Block<T>>(Elements.length() + 1);
		for (int i = 0; i < Elements.length(); i++) {
			newArray.set(i, Elements.get(i));
		}
		newArray.set(newArray.length() -1 , new Block<T>(BlockSize));

		this.Elements = newArray;
	}
}
