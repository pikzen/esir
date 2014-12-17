package tableau;

import java.util.ArrayList;
import java.util.List;

import types.Array;
/**
* Tableau redimensionnable, implémenté via un Array<T>
*/
public class BlockTP<T> implements Tableau<T> {
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
	public BlockTP(int capacite) {
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
	
	/**
	 * Rajoute <code>autre</code> à la suite de ce Block.
	 * Redimensionne ce Block et modifie <code>Elements</code>
	 * @param other
	 */
	public void concat(Tableau<T> other) {
		int totalSize = this.size() + other.size();
		
		Array<T> newBlock = new Array<T>(totalSize);
		
		// Copie des éléments de ce tableau
		for (int i = 0; i < this.size(); i++) {
			newBlock.set(i, this.get(i));
		}
		// Copie des éléments de l'autre tableau
		int baseIndex = this.size();
		for (int i = baseIndex, j = 0; i < baseIndex + other.size(); i++, j++) {
			newBlock.set(i, other.get(j));
		}
		
		this.Elements = newBlock;
		this.MaximumSize = totalSize;
		this.Size = totalSize;
	}
	
	/**
	 * Cherche les indices auquels <code>search</code> est présent dans le tableau
	 * @param search
	 * @return
	 */
	public List<Integer> chercherIndices(T search) {
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(search)) {
				indices.add(i);
			}
		}
		
		return indices;
	}
	
	/**
	 * Découpe un tableau en sous tableaux séparés par <code>s</code>
	 * @param s
	 * @return
	 */
	public List<Tableau<T>> decouper(T s) {
		List<Tableau<T>> elements = new ArrayList<Tableau<T>>();
		int currentIndex = 0;
		
		while (currentIndex < this.size()) {
			Tableau<T> temp = new BlockTP<T>(this.MaximumSize);
			// On insere tous les éléments différents de s
			while (currentIndex < this.size() && !this.get(currentIndex).equals(s)) {
				temp.push_back(this.get(currentIndex));
				currentIndex++;
			}
			
			elements.add(temp);
			currentIndex++;
		}
		
		if (this.get(currentIndex - 1).equals(s)) {
			elements.add(new BlockTP<T>(0));
		}
		
		return elements;
	}
}


