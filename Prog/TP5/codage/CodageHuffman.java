package codage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import outilsHuffman.OutilsHuffman;
import types.ABinHuffman;
import types.Couple;
import types.ListeABH;

/**
 * Réalisation du codage d'un texte par la méthode de Huffman
 */

public class CodageHuffman
{
  public static void main (String[] args)
  {
    //------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à coder (À FAIRE)
    //------------------------------------------------------------------------
    String nomFichier = "exemple.txt";

    //------------------------------------------------------------------------
    // 1. Lire le texte (DONNÉ)
    //------------------------------------------------------------------------
    char [] texte = OutilsHuffman.lireFichier(nomFichier);

    //------------------------------------------------------------------------
    // 2. Calculer la table des fréquences des caractères (À FAIRE)
    //------------------------------------------------------------------------
    int [] tableFrequences = calculerFrequences(texte);

    //------------------------------------------------------------------------
    // 3. Enregistrer la table de fréquences dans le fichier de sortie (DONNÉ)
    //------------------------------------------------------------------------
    OutilsHuffman.enregistrerTableFrequences(tableFrequences, nomFichier + ".code");

    //------------------------------------------------------------------------
    // 4. Construire l'arbre de codage de Huffman (DONNÉ - À FAIRE)
    //------------------------------------------------------------------------
    ABinHuffman arbreCodageHuffman = construireArbreHuffman(tableFrequences);

    //------------------------------------------------------------------------
    // Afficher l'arbre de codage de Huffman (DÉJÀ FAIT)
    //------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    DecodageHuffman.afficherHuffman(arbreCodageHuffman);

    //------------------------------------------------------------------------
    // 5. Construire la table de codage associée (À FAIRE)
    //------------------------------------------------------------------------
    String [] tablecodage = construireTableCodage(arbreCodageHuffman);

    //------------------------------------------------------------------------
    // 5.1. afficher la table de codage (À FAIRE)
    //------------------------------------------------------------------------
    System.out.println("Table de codage associée au texte " + nomFichier);
    afficherTableCodage(tablecodage);

    //------------------------------------------------------------------------
    // 6. coder le texte avec l'arbre de Huffman (À FAIRE)
    //------------------------------------------------------------------------
    StringBuilder texteCode = coderTexte(texte, tablecodage);

    //------------------------------------------------------------------------
    // 7. enregistrer le texte codé (DONNÉ)
    //------------------------------------------------------------------------
    OutilsHuffman.enregistrerTexteCode(texteCode, nomFichier + ".code");

    //------------------------------------------------------------------------
    // xx. calculer et afficher les stats (À FAIRE)
    //------------------------------------------------------------------------
    // calculer la taille du fichier non codé
    // calculer la taille du fichier codé

  }

  /**
   * 2. calculer la fréquence d'apparition de chaque caractère
   * @param  tcar tableau des caractères du texte
   * @return tableau de fréquence des caractères, indicé par les caractères
   */
  public static int [] calculerFrequences(char [] tcar)
  {
	  int[] bob = new int[256];
	  
	  /* Parcourir le tableau des caractères du texte, incrémenter quand caractère trouvé ! */
	  for(int i = 0; i < tcar.length; i++){
		  bob[tcar[i]]++;
	  }
	  
	  return bob;
  }

  /**
   * 4. construire un arbre de codage de Huffman par sélection et combinaison
   * des éléments minimaux
   * @param tableFrequences table des fréquences des caractères
   * @return arbre de codage de Huffman
   */
  public static ABinHuffman construireArbreHuffman(int [] tableFrequences)
  {
	  List<ABinHuffman> bob = new ArrayList<ABinHuffman>(); /* Liste à retourner */
	  
	  for(int i = 0; i < tableFrequences.length; i++){ /* Pour chaque élément du tableau tableFréquences */
		  if(tableFrequences[i] != 0){ /* Si le code ASCII i est présent au moins une fois */
			  ABinHuffman  elem = new ABinHuffman();
			  elem.setValeur(new Couple<Character, Integer>((char) i, tableFrequences[i]));
			  bob.add(elem);
		  }
	  }
	  Collections.sort(bob ,new Comparator<ABinHuffman>() { /* Pour trier notre arbre bin */

		@Override
		public int compare(ABinHuffman o1, ABinHuffman o2) {
			return o1.getValeur().deuxieme().compareTo(o2.getValeur().deuxieme());
		}

		  
	  });
	  
	  while(bob.size() != 1){ /* Tant qu'il reste plus d'un caractère */
		
		  ABinHuffman tree = new ABinHuffman(); /* Notre arbre à ajouter dans bob */
		  int percent = bob.get(0).getValeur().deuxieme()+bob.get(1).getValeur().deuxieme(); /* Pour la valeur du père */
		  
		  tree.setValeur(new Couple<Character, Integer>('b', percent));
		  ABinHuffman left = new ABinHuffman(); /* Pour la valeur de gauche */
		  left.setValeur(bob.get(0).getValeur());
		  tree.setGauche(left);
		  
		  ABinHuffman right = new ABinHuffman(); /* Pour la valeur de droite */
		  right.setValeur(bob.get(1).getValeur());
		  tree.setDroit(right);
		  
		  int index = 0;
		  while (bob.get(index).getValeur().deuxieme() >= tree.getValeur().deuxieme()) { /* Pour l'indexer au bon endroit */
			  index++;
		  }
		  bob.add(index, tree); /* On ajoute l'arbre à bob */
		  
		  bob.remove(0); /* On les remove pour les enlever de la liste */
		  bob.remove(0);
		  
	  }
	  
	  return bob.get(0); /* On retourne l'arbre */
  }

  /**
   * 4.1 Faire une liste triée dont chaque élément est un arbreBinaire<br>
   * comprenant un unique sommet dont l'étiquette est un couple
   * <caractère, fréquence>, trié par fréquence croissante
   * @param tableFrequences : table des fréquences des caractères
   * @return		      la liste triée
   */
  private static ListeABH faireListeAbinHuffman(int [] tableFrequences)
  {
	  
	  
	  return null;
  }

  /**
   * 5. construire la table de codage correspondant à l'arbre de Huffman
   * @param abinHuff : arbre de Huffman
   * @return table de (dé)codage indicé par lex caractères
   */
  public static String [] construireTableCodage(ABinHuffman abinHuff)
  {
	  return null;
  }

  /**
   * 5.1. Afficher la table de codage associée au texte
   * @param tablecodage : table de codage associée au texte
   */
  public static void afficherTableCodage(String [] tablecodage)
  {
  }

  /**
   * 6. Coder un texte à l'aide de la table de codage
   * @param texte à coder
   * @param tablecodage : table de codage associée au texte
   * @return texte codé
   */
  public static StringBuilder coderTexte(char [] texte, String [] tablecodage)
  {
	  return null;
  }
}// CodageHuffman
