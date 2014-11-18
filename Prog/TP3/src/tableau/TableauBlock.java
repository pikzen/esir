package tableau;

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

	/**
	* Construit un nouveau tableau de capacité maximale <code>capacite</code>
	* @param capacite Capacité maximale du tableau
	*/
	public TableauBlock(int maxSize, int capaciteBlock) {
			int currentBlock = 0;
			int currentTabSize = 0;
			BlockSize = capaciteBlock;
			MaximumSize = maxSize;

			// Calcul de la taille d'Elements
			int subBlock = 0;
			int copy = i;
			while (copy > BlockSize) {
				copy -= BlockSize;
				subBlock++;
			}
			Elements = new Array(subBlock+1);


			while (currentTabSize < maxSize) {
				Block<T> block = new Block<T>(capaciteBlock);
				Elements.set(currentBlock, block);

				currentTabSize += capaciteBlock;
				currentBlock++;
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

		int subBlock = 0;
		int copy = i;
		while (copy > BlockSize) {
			copy -= BlockSize;
			subBlock++;
		}
		int blockPos = i - (subBlock * BlockSize);
		return this.Elements.get(subBlock).get(blockPos);
	}

	/**
	* Modifie l'élément à l'indice i
	* @param i Index de l'élément à modifier
	* @pre 0 <= i < this.size()
	* @param elem Nouvelle valeur de l'élément
	*/
	public void set(int i, T elem) {
		assert i >= 0 && i < this.size();

		int subBlock = 0;
		int copy = i;
		while (copy > BlockSize) {
			copy -= BlockSize;
			subBlock++;
		}
		int blockPos = i - (subBlock * BlockSize);

		this.Elements.get(subBlock).set(blockPos, elem);
	}

	/**
	* Ajoute un élément en fin de tableau
	* @param elem Element à ajouter
	* @pre !this.full()
	*/
	public void push_back(T elem) {
		assert !this.full();

		this.set(Size, elem);
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
	*/
	private void resize() {
		this.MaximumSize += BlockSize;

		Array<Block<T>> newArray = new Array(Elements.length() + 1);
		for (int i = 0; i < newArray.length() - 2; i++) {
			newArray.set(i, Elements.get(i));
		}
		newArray.set(newArray.length() - 1, new Block<T>(BlockSize));
	}
}
