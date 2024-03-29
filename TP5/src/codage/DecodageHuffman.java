package codage;
import java.util.HashMap;

import outilsHuffman.OutilsHuffman;
import types.ABinHuffman;


/**
 * Réalisation du décodage d'un texte par la méthode de Huffman
 */

public class DecodageHuffman
{
  public static void main (String[] args)
  {
    //------------------------------------------------------------------------
    // 0. Saisir le nom du fichier à décoder (À FAIRE)
    //------------------------------------------------------------------------
    String nomFichier = "/private/student/6/36/13004636/workspace/TP5/exemple.txt.code" ;

    //------------------------------------------------------------------------
    // 1. Lire et construire la table de fréquences (DONNÉ)
    //------------------------------------------------------------------------
    int [] tableFrequences = OutilsHuffman.lireTableFrequences(nomFichier);

    //------------------------------------------------------------------------
    // 2. Construire l'arbre de Huffman (DONNÉ)
    //------------------------------------------------------------------------
    ABinHuffman arbreHuffman =
      OutilsHuffman.construireArbreHuffman(tableFrequences);

    //------------------------------------------------------------------------
    // 2.1 afficher l'arbre de Huffman (À FAIRE)
    //------------------------------------------------------------------------
    System.out.println("Arbre de Huffman associé au texte " + nomFichier);
    afficherHuffman(arbreHuffman);

    //------------------------------------------------------------------------
    // 3. Lire le texte codé (DONNÉ)
    //------------------------------------------------------------------------
    String texteCode = OutilsHuffman.lireTexteCode(nomFichier);

    //------------------------------------------------------------------------
    // 4. Décoder le texte (À FAIRE)
    //------------------------------------------------------------------------
    StringBuilder texteDecode = decoderTexte(texteCode, arbreHuffman);

    //------------------------------------------------------------------------
    // 5. Enregistrer le texte décode (DONNÉ)
    //------------------------------------------------------------------------
    System.out.println("texte décodé:\n\n" + texteDecode);
    OutilsHuffman.enregistrerTexte(texteDecode, nomFichier + ".decode");
  }

  /**
   * 4. décoder une chaîne (non vide) encodée par le codage de Huffman
   * @param texteCode    : chaîne de "0/1" à décoder
   * @param arbreHuffman : arbre de (dé)codage des caractères
   */
  public static StringBuilder decoderTexte(String texteCode, ABinHuffman arbreHuffman)
  {
	  HashMap<String, Character> liste = new HashMap<String, Character>();
	  int index = 0;
	  
	  char valeur = texteCode.charAt(index);
	  
	  
	  
	  return null;
	  
  }
  
  public static void readTree(ABinHuffman binhuff, String encode, HashMap<String, Character> listHash){
	 /* Si l'arbre est une feuille */
	  
	  if(binhuff.estFeuille()){
		  listHash.put(encode, binhuff.getValeur().premier()); /* On le met dans le HashMap la premiere valeur */
	  }
	  
	  
	  
  }

  /**
   * 2.1 afficher un arbre de Huffman
   * @param a : arbre binaire de Huffman
   */
  public static void afficherHuffman(ABinHuffman a)
  {
  }
} // DecodageHuffman
