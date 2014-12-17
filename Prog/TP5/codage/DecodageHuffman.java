package codage;

import java.util.HashMap;

import types.ABinHuffman;
import outilsHuffman.OutilsHuffman;

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
		String nomFichier = "D:/Code/ESIR/Prog/TP5/exemple.txt.code";

	//------------------------------------------------------------------------
	// 1. Lire et construire la table de fréquences (DONNÉ)
	//------------------------------------------------------------------------
		int [] tableFrequences = OutilsHuffman.lireTableFrequences(nomFichier);
		/*for (int i = 25; i < tableFrequences.length; i++) {
			System.out.print(Character.toChars(i));
		}
		System.out.println();
		for (int i = 29; i < tableFrequences.length; i++) {
			System.out.print(tableFrequences[i]);
		}*/

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
	HashMap<String, Character> huffman = new HashMap<String, Character>();

	// On récupere une liste de couples, et on l'insère dans la hashmap
	readTree(arbreHuffman, "", huffman);

	// On passe sur chaque groupe de caractères jusqu'a ce qu'on trouve une clé correspondante
	StringBuilder sb = new StringBuilder();
	boolean read = false;
	int baseIdx = 0;
	int charSize = 1;

	while (!read) {
		// On séléctionne les x caractères suivants, x augmentant tant qu'on a pas trouvé de caractère correspondant.
		String sub = texteCode.substring(baseIdx, baseIdx + charSize);

		// Si il existe une clé y correspondant, on ajoute le caractère dans le message, et on passe aux sous-chaines suivantes
		if (huffman.containsKey(sub)) {
			sb.append(huffman.get(sub));
			baseIdx += charSize;
			charSize = 1;
		}
		else {
			// On essaie avec une sous-chaine plus longue
			charSize++;
		}

		// On est arrivé à la fin du texte, on arrête
		if (baseIdx + charSize == texteCode.length() + 1) {
			read = true;
		}
	}
	System.out.println(sb.toString());
	return sb;
  }

  private static void readTree(ABinHuffman tree,
  							   String encoding,
  							   HashMap<String, Character> data) {
	// On v�rifie si cet arbre est une feuille
	if (tree.estFeuille()) {
		data.put(encoding, tree.getValeur().premier());
		return;
	}

	readTree(tree.filsGauche(), encoding + "0", data);
	readTree(tree.filsDroit(), encoding + "1", data);
  }

  /**
   * 2.1 afficher un arbre de Huffman
   * @param a : arbre binaire de Huffman
   */
  public static void afficherHuffman(ABinHuffman a)
  {
  }
} // DecodageHuffman
