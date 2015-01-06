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
	
	/*---------------------------*/
	/* FONCTION DE CONCATENATION */
	/*---------------------------*/
	
	public void concat(Tableau<T> autre){
		int taille = this.size() + autre.size(); /* Tableau assez grand */
		
		Array<T> newTab = new Array<T>(taille); /* Mon nouveau tableau de cette taille */
		
		/* on va copier les éléments le tableau */
		
		for(int i = 0; i < this.size(); i++){
			newTab.set(i,  this.get(i)); /* On remplit le tableau avec les valeurs de notre tableau de base*/
		}
		
		int baseIndx = this.size(); /* Je reprends le compteur à la taille ou s'est arrêté le tableau */
		for(int j = baseIndx, h = 0; j < baseIndx + autre.size(); j++, h++){ /* Pour chaque case du tableau j'incrémente un autre compteur */
			newTab.set(j, autre.get(h)); /* Je peux insérer après la taille du tableau de base mon tableau autre */
		}
		
		this.Elements = newTab; /* Je change le tableau */
		this.MaximumSize = taille; /* Je change la taille maximale et la taille actuelle */
		this.Size = taille;
		
	}
	
	/* @AUTHOR : Corentin HOUCHARD */
	
	/*--------------------------*/
	/* FONCTION CHERCHER INDICES */
	/*--------------------------*/
	
	public List<Integer> chercherIndices(T x){
		List<Integer> listIndc = new ArrayList<Integer>(); /* Ma nouvelle liste à renvoyer */ 
		for(int i = 0; i < this.size(); i++){ /* ON parcourt chaque élément de this */
			if(this.get(i).equals(x)){ /* Si il y en a un égal à x */
				listIndc.add(i); /* On le rajoute dans le tableau à retourner */
			}
		}
		
		return listIndc;
	}
	
	/*-----------------------*/
	/* FONCTION DE DECOUPAGE */
	/*----------------------*/
	
	public List<Tableau<T>> decouper(T x){
		List<Tableau<T>> listReturn = new ArrayList<Tableau<T>>(); /* Ceci est la liste que je retourne */
		int indiceCourant = 0; /* Je déclare mon indice courant */
		
		while(indiceCourant < this.size()){ /* Tant que cet indice est inférieur à la taille du tableau this */
			Tableau<T> inter = new BlockTP<T>(this.MaximumSize); /* On crée un nouveau tableau avec la taille maximale */
		
			
			while(indiceCourant < this.size() && !this.get(indiceCourant).equals(x)){ /* Tant que mon indice est inférieur à la taille de this et que x n'y est pas */
				
				inter.push_back(this.get(indiceCourant)); /* On ajoute à la fin le contenu de this à l'indice indiceCourant */
				indiceCourant++; /* J'incrémente mon indice courant pour reprendre après l'indice de x */
				
			}
			
			
			listReturn.add(inter); /* J'ajoute le tableau dans ma liste à retourner */
			indiceCourant++; /* J'augmente l'indice courant */
		}
		
		if(this.get(indiceCourant - 1).equals(x)){ /* Pour vérifier si le dernier block possède x */
			
			listReturn.add(new BlockTP<T>(0)); /* Si oui cela renvoie un block vide */
		}
		
		return listReturn;
	}
}
