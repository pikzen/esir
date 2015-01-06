package test;
import java.util.List;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import tableau.BlockTP;
import tableau.Tableau;

public class TestUnitaireBlockTP
{
  // À changer selon besoin
  static Tableau<Integer> makeTableau(int capacite) {
    return new BlockTP<Integer>(capacite);
  }


  // constructeur : vérifier l'état initial du tableau
  @Test
  public void testEtatInitial()
  {
    // System.out.print("\nconstructeur : vérifier l'état initial du tableau ; tableau vide et non plein : ");
    System.out.print("\nconstructeur : ");
    Tableau<Integer> b1 = makeTableau(10);
    // tableau b1 initialement vide
    Assert.assertTrue("Erreur : taille incorrecte : " + b1.size() + " au lieu de 0", b1.size() == 0);
    // tableau non plein
    Assert.assertFalse("Erreur : ne devrait pas être plein : " + b1.full(), b1.full());
    System.out.println("Test réussi");
  }

  // size : vérifier que la taille augmente correctement après chaque ajout 
  // et diminue correctement après chaque retrait
  @Test
  public void testSize()
  {
    // System.out.print("\nsize : vérifier que la taille augmente correctement après chaque ajout \n\tet diminue correctement après chaque retrait : ");
    System.out.print("\nsize : ");
    Tableau<Integer> b1 = makeTableau(10);
    // tableau b1 initialement vide
    Assert.assertTrue("Erreur : taille incorrecte : " + b1.size() + " au lieu de 0", b1.size() == 0);
    // ajouter 7 éléments
    int taille_b1 = 0;
    for (int nb = 0; nb < 7; ++nb) {
      b1.push_back(5);
      ++taille_b1;
      Assert.assertTrue("Erreur : taille incorrecte : " + b1.size() + " au lieu de "+ taille_b1, b1.size() == taille_b1);
    }
    // retirer 7 éléments
    for (int nb = 0; nb < 7; ++nb) {
      b1.pop_back();
      --taille_b1;
      Assert.assertTrue("Erreur : taille incorrecte : " + b1.size() + " au lieu de "+ taille_b1, b1.size() == taille_b1);
    }
    System.out.println("Test réussi");
  }

  // empty : vérifier qu'un tableau vide ne l'est plus après ajout d'un élément
  // et qu'un tableau non vide le devient après retrait de tous ses éléments
  @Test
  public void testEmpty()
  {
    // System.out.print("\nempty : vérifier qu'un tableau vide ne l'est plus après ajout d'un élément\n\tet qu'un tableau non vide le devient après retrait de tous ses éléments : ");
    System.out.print("\nempty : ");
    Tableau<Integer> b1 = makeTableau(10);
    Assert.assertTrue("Erreur : le tableau devrait être vide : " + b1.empty(), b1.empty());
    // ajouter 7 éléments
    for (int nb = 0; nb < 7; ++nb) {
      b1.push_back(5);
      Assert.assertTrue("Erreur : le tableau ne devrait pas être vide : " + b1.empty(), !b1.empty());
    }
    // retirer 7 éléments
    for (int nb = 0; nb < 7; ++nb) {
      b1.pop_back();
    }
    Assert.assertTrue("Erreur : le tableau devrait être vide : " + b1.empty(), b1.empty());
    System.out.println("Test réussi");
  }

  // full : vérifier qu'un tableau non plein le devient quand on le remplit :)
  // et qu'un tableau plein ne l'est plus quand on enlève un élément
  @Test
  public void testFull()
  {
    // System.out.print("\nfull : vérifier qu'un tableau non plein le devient quand on le remplit :)\n\tet qu'un tableau plein ne l'est plus quand on enlève un élément : ");
    System.out.print("\nfull : ");
    Tableau<Integer> b1 = makeTableau(10);
    Assert.assertFalse("Erreur : le tableau ne devrait pas être plein : " + b1.full(), b1.full());
    // ajouter des éléments
    for (int i = 1; i <= 9; ++i) {
      b1.push_back(5);
      Assert.assertFalse("Erreur : le tableau ne devrait pas être plein : " + b1.full(), b1.full());
    }
    // finir de remplir le tableau
    b1.push_back(5);
    Assert.assertTrue("Erreur : le tableau devrait être plein : " + b1.full(), b1.full());
    // ôter un élément
    b1.pop_back();
    Assert.assertFalse("Erreur : le tableau ne devrait pas être plein : " + b1.full(), b1.full());
    System.out.println("Test réussi");
  }

  // get : vérifier qu'un élément ajouté a bien la bonne valeur
  @Test
  public void testGet()
  {
    // System.out.print("\nget : vérifier qu'un élément ajouté a bien la bonne valeur : ");
    System.out.print("\nget : ");
    Tableau<Integer> b2 = makeTableau(10);
    // ajouter un élément et vérifier sa valeur
    b2.push_back(66);
    Assert.assertTrue("b2[" + (b2.size()-1) + "]=" + b2.get(b2.size()-1) + " au lieu de 66", b2.get(b2.size()-1) == 66);
    System.out.println("Test réussi");
  }

  // set : vérifier qu'après modification un élément a bien sa nouvelle valeur
  @Test
  public void testSet()
  {
    // System.out.print("\nset : vérifier qu'après modification un élément a bien sa nouvelle valeur : ");
    System.out.print("\nset : ");
    Tableau<Integer> b2 = makeTableau(10);
    // ajouter un élément et vérifier sa valeur
    b2.push_back(66);
    Assert.assertTrue("b2[" + (b2.size()-1) + "]=" + b2.get(b2.size()-1) + " au lieu de 66", b2.get(b2.size()-1) == 66);
    for (int i = 0; i < b2.size(); ++i) {
      b2.set(i, 3*i+1);
      Assert.assertTrue("b2[" + i + "]=" + b2.get(i) + " au lieu de " + (3*i+1), b2.get(i) == 3*i+1);
    }
    System.out.println("Test réussi");
  }

  // push_back : vérifier qu'après ajout : 
  // - la taille a augmenté
  // - l'élément ajouté a la bonne valeur
  // - après modif les éléments ont la bonne valeur
  @Test
  public void testPush_back()
  {
    // System.out.print("\npush_back :vérifier qu'après ajout la taille a augmenté et l'élément ajouté a la bonne valeur : ");
    System.out.print("\npush_back : ");
    // ajouter des éléments dans un tableau initialement vide
    Tableau<Integer> b1 = makeTableau(10);
    int taille = 0;
    while (! b1.full()) {
      b1.push_back(taille);
      Assert.assertTrue("Erreur : la taille devrait être " + (taille+1) + " et non " + b1.size(), b1.size() == taille+1);
      taille += 1;
    }
    // vérifier la valeur des éléments
    for (int i = 0; i < b1.size(); ++i) {
      Assert.assertTrue("b1[" + i + "]=" + b1.get(i) + " au lieu de " + i, b1.get(i) == i);
    }
    // modifier la valeur des éléments
    for (int i = 0; i < b1.size(); ++i) {
      b1.set(i, b1.get(i) * 2);
    }
    // vérifier la valeur des éléments
    for (int i = 0; i < b1.size(); ++i) {
      Assert.assertEquals(i * 2, (int) b1.get(i));
    }
    System.out.println("Test réussi");
  }

  // pop_back : vérifier qu'après retrait la taille a diminué d'une unité 
  @Test
  public void testPop_back()
  {
    // System.out.print("\npop_back : vérifier que la taille a diminué d'une unité : ");
    System.out.print("\npop_back : ");
    // ajouter des éléments dans un tableau initialement vide
    Tableau<Integer> b1 = makeTableau(10);
    int taille = 0;
    while (! b1.full()) {
      b1.push_back(taille);
      Assert.assertTrue("Erreur : la taille devrait être " + (taille+1) + " et non " + b1.size(), b1.size() == taille+1);
      taille += 1;
    }
    b1.pop_back();
    Assert.assertTrue("Erreur : la taille devrait être " + 9 + " et non " + b1.size(), b1.size() == 9);
    System.out.println("Test réussi");
  }

  //------------------------------------------------------------------------
  // tester concat
  //------------------------------------------------------------------------

  String [] tchaines1 = {
      "azerty",
      "cromagnon",
      "/usr/share/java/junit4.jar:/home/engel/lib/outilsArbre.jar:/home/engel/lib/types.jar:./bin",
      "bin/test/TestUnitaireBlockTP.class",
      "tableau non vide",
      "gettext-common-devel-0.18.3.2-2.fc20.noarch",
      "perl-Pod-Checker-1.60-291.fc20.noarch",
      "lz4-r124-1.fc20.i686",
      "/usr/libexec/mate-panel/wnck-applet",
      "/etc/alternatives/java_sdk/bin/java",
      "*** Erreurs de compilation ***",
      "[Errno 14] HTTP Error 404 - Not Found",
      "http://ftp.uni-koeln.de/mirrors/fedora/linux/updates/20/i386/drpms/gettext-devel-0.18.3.2-2.fc20_0.18.3.2-3.fc20.i686.drpm:",
      "Installation pour dépendances :",
      "yum-langpacks.noarch 0:0.4.4-1.fc20",
      "utilisez « search all » pour une recherche complète.",
  };
  String [] tchaines2 = {
      "./AP/tp/99_controle_tp/src/tableau/BlockTP.java",
      "kmod-wl-3.16.7-200.fc20.x86_64.x86_64",
      "org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding::",
      "entering extended mode",
      "pdfTeX, Version 3.1415926-2.6-1.40.14",
      "Calling CRDA to update world regulatory",
      "supplicant interface state: disconnected -> scanning",
      "coding exception was thrown",
  };

  String [] concat(String [] t1, String [] t2)
  {
    String [] tc = new String[t1.length + t2.length];
    for (int i = 0; i < t1.length; ++i) { tc[i] = new String(t1[i]); }
    for (int i = 0; i < t2.length; ++i) { tc[i + t1.length] = new String(t2[i]); }
    return tc;
  }

  // 2 tableaux vides...
  @Test
  public void concat_vide_vide()
  {
    System.out.print("\n*** concaténer 2 tableaux vides : ");
    BlockTP<String> b1 = new BlockTP<String>(10);
    BlockTP<String> b2 = new BlockTP<String>(25);
    // concaténer
    b1.concat(b2);
    Assert.assertTrue("Tableau concaténé devrait être vide " +  b1.empty(), b1.empty());
    verifBloc(b1, new String[]{});
    // vérifier que b2 n'a pas changé
    Assert.assertTrue("Tableau paramètre devrait être vide " +  b2.empty(), b2.empty());
    verifBloc(b2, new String[]{});
    System.out.println("Test réussi");
  }

  @Test
  public void concat_vide_nonvide()
  {
    System.out.print("\n*** concaténer 1 tableau vide et 1 non vide : ");
    BlockTP<String> b1 = new BlockTP<String>(10);
    BlockTP<String> b2 = (BlockTP<String>) initialiserTableau(tchaines2);
    // concaténer
    b1.concat(b2);
    // vérifier b1
    verifBloc(b1, tchaines2);
    // vérifier que b2 n'a pas changé
    verifBloc(b2, tchaines2);
    System.out.println("Test réussi");
  }

  @Test
  public void concat_nonvide_vide()
  {
    System.out.print("\n*** concaténer 1 tableau non vide et 1 vide : ");
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);
    BlockTP<String> b2 = new BlockTP<String>(10);
    // concaténer
    b1.concat(b2);
    // vérifier b1
    verifBloc(b1, tchaines1);
    // vérifier que b2 n'a pas changé
    verifBloc(b2, new String[]{});
    System.out.println("Test réussi");
  }

  @Test
  public void concat_2nonvides()
  {
    System.out.print("\n*** concaténer 2 tableaux non vides (v1) : ");
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);
    BlockTP<String> b2 = (BlockTP<String>) initialiserTableau(tchaines2);
    // concaténer
    b1.concat(b2);
    // vérifier b1
    verifBloc(b1, concat(tchaines1, tchaines2));
    // vérifier que b2 n'a pas changé
    verifBloc(b2, tchaines2);
    System.out.println("Test réussi");
  }

  @Test
  public void concat_2nonvidesV2()
  {
    System.out.print("\n*** concaténer 2 tableaux non vides (v2) : ");
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines2);
    BlockTP<String> b2 = (BlockTP<String>) initialiserTableau(tchaines1);
    // concaténer
    b1.concat(b2);
    // vérifier b1
    verifBloc(b1, concat(tchaines2, tchaines1));
    // vérifier que b2 n'a pas changé
    verifBloc(b2, tchaines1);
    System.out.println("Test réussi");
  }

  //------------------------------------------------------------------------
  // tester chercherIndices
  //------------------------------------------------------------------------

  Tableau<String> initialiserTableau(String [] chaines)
  {
    Tableau<String> bloc = new BlockTP<String>(chaines.length*10);
    for (int i = 0; i < chaines.length; ++i) {
      bloc.push_back(new String(chaines[i]));
    }
    return bloc;
  }

  Tableau<Integer> initialiserTableau(int [] donnees)
  {
    Tableau<Integer> bloc = new BlockTP<Integer>(donnees.length*10);
    for (int i = 0; i < donnees.length; ++i) {
      bloc.push_back(new Integer(donnees[i]));
    }
    return bloc;
  }

  // 1. x absent
  @Test
  public void chercherIndices_xabsent()
  {
    System.out.print("\n*** chercherIndices ; x absent : ");
    // ajouter des éléments dans un tableau initialement vide
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);
    // chercher un élt absent
    List<Integer> lind = b1.chercherIndices("absent");
    Assert.assertTrue("liste devrait être vide, mais taille = " + lind.size(), 
	lind.isEmpty());
    System.out.println("Test réussi");
  }

  // 2. x présent 1 fois
  @Test
  public void chercherIndices_x1fois()
  {
    System.out.print("\n*** chercherIndices ; x présent une fois : ");
    // créer et initialiser un tableau
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);

    // chercher chacun des éléments du tableau tchaines1 dans le tableau b1
    for (int pos = 0; pos < b1.size(); ++pos) {
      // System.out.print("\n    Recherche de «" + tchaines1[pos] + "» à l'indice " + pos + " : ");
      List<Integer> lind = b1.chercherIndices(new String(tchaines1[pos]));
      Assert.assertTrue("Taille incorrecte (" + lind.size() + " au lieu de 1)",
	  lind.size() == 1);
      Assert.assertTrue("Valeur incorrecte (" + lind.get(0) + " au lieu de " + pos + ")",
	  lind.get(0) == pos);
    }
    System.out.println("Test réussi");
  }

  // 3. x présent plusieurs fois
  @Test
  public void chercherIndices_xNfois()
  {
    System.out.print("\n*** chercherIndices ; x présent N fois : ");
    String [] donnees = {
	"azerty",
	"azerty",
	"cromagnon",
	"zoroastre",
	"azerty",
	"azerty",
	"cromagnon",
	"zoroastre",
	"zoroastre",
    };
    int [][] solutions = {
	{ 0, 1, 4, 5, },
	{ 0, 1, 4, 5, },
	{ 2, 6, },
	{ 3, 7, 8, },
	{ 0, 1, 4, 5, },
	{ 0, 1, 4, 5, },
	{ 2, 6, },
	{ 3, 7, 8, },
	{ 3, 7, 8, },
    };

    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(donnees);

    for (int id = 0; id < donnees.length; ++id) {
      // System.out.print("\n    Recherche de «" + donnees[id] + "» à l'indice " + id + " : ");
      List<Integer> lind = b1.chercherIndices(new String(donnees[id]));
      Assert.assertTrue("Taille incorrecte (" + lind.size() + " au lieu de " + solutions[id].length, 
	  lind.size() == solutions[id].length);
      for (int js = 0; js < solutions[id].length; ++js) {
	Assert.assertTrue("Valeur incorrecte (" + lind.get(js) + " au lieu de " + solutions[id][js] + ")",
	    lind.get(js) == solutions[id][js]);
      }

    }
    System.out.println("Test réussi");
  }

  // 4. tous les éléments identiques à l'élément cherché
  @Test
  public void chercherIndices_identiques()
  {
    System.out.print("\n*** chercherIndices ; tous les éléments identiques : ");
    String [] donnees = {
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
    };

    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(donnees);

    List<Integer> lind = b1.chercherIndices(new String(donnees[0]));
    Assert.assertTrue("Taille incorrecte (" + lind.size() + " au lieu de " + donnees.length, 
	lind.size() == donnees.length);
    for (int js = 0; js < donnees.length; ++js) {
      Assert.assertTrue("Valeur incorrecte (" + lind.get(js) + " au lieu de " + js + ")",
	  lind.get(js) == js);
    }
    System.out.println("Test réussi");
  }

  //------------------------------------------------------------------------
  // tester decouper
  //------------------------------------------------------------------------

  // x absent
  @Test
  public void decouper_xabsent()
  {
    System.out.print("\n*** Découper ; x absent : ");
    // initialiser un tableau
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);
    int taille1 = tchaines1.length;
    // découper selon un élt absent
    List<Tableau<String>> lblocs = b1.decouper("absent");
    Assert.assertTrue("Taille liste incorrecte  (" + lblocs.size() + " au lieu de " + 1 + ")",
	lblocs.size() == 1);
    // vérifier le contenu de la liste
    Tableau<String> t = lblocs.get(0);
    Assert.assertTrue("Taille sous-bloc" + 1 + " incorrecte (" + t.size() + " au lieu de " + (taille1) + ")",
	t.size() == taille1);
    for (int i = 0; i < taille1; ++i) {
      Assert.assertTrue("Valeur incorrecte (" + t.get(i) + " au lieu de " + tchaines1[i] + ")",
	  t.get(i).equals(tchaines1[i]));
    }
    //  vérifier que b1 n'a pas changé
    verifBloc(b1, tchaines1);
    System.out.println("Test réussi");
  }

  // x présent 1 fois
  @Test
  public void decouper_1fois()
  {
    System.out.print("\n*** Découper ; x présent une fois : ");
    // créer et initialiser un tableau
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(tchaines1);

    // découper b1 selon chacun des éléments du tableau tchaines1
    for (int pos = 0; pos < b1.size(); ++pos) {
      List<Tableau<String>> lblocs = b1.decouper(new String(tchaines1[pos]));
      Assert.assertTrue("Taille incorrecte (" + lblocs.size() + " au lieu de 2)",
			lblocs.size() == 2);
      // vérifier la taille et le contenu des deux sous-blocs
      verifBloc(lblocs.get(0), tchaines1, 0, pos);
      verifBloc(lblocs.get(1), tchaines1, pos+1, tchaines1.length - pos - 1);
    }
    //  vérifier que b1 n'a pas changé
    verifBloc(b1, tchaines1);
    System.out.println("Test réussi");
  }

  // x présent plusieurs fois
  @Test
  public void decouper_nfois()
  {
    System.out.print("\n*** Découper ; x présent N fois : ");
    String [] donnees = {
      "azerty",		// 0
      "azerty",		// 1
      "cromagnon",	// 2
      "zoroastre",	// 3
      "azerty",		// 4
      "azerty",		// 5
      "cromagnon",	// 6
      "zoroastre",	// 7
      "zoroastre",	// 8
    };
    String [][][] solutions = {
      /* azerty    */ { {}, {}, { "cromagnon", "zoroastre", }, {}, { "cromagnon", "zoroastre", "zoroastre", }, },
      /* azerty    */ { {}, {}, { "cromagnon", "zoroastre", }, {}, { "cromagnon", "zoroastre", "zoroastre", }, },
      /* cromagnon */ { { "azerty", "azerty", }, {"zoroastre", "azerty", "azerty",}, { "zoroastre", "zoroastre", }, },
      /* zoroastre */ { { "azerty", "azerty", "cromagnon",  },  { "azerty", "azerty", "cromagnon",  }, {}, {}, },
      /* azerty    */ { {}, {}, { "cromagnon", "zoroastre", }, {}, { "cromagnon", "zoroastre", "zoroastre", }, },
      /* azerty    */ { {}, {}, { "cromagnon", "zoroastre", }, {}, { "cromagnon", "zoroastre", "zoroastre", }, },
      /* cromagnon */ { { "azerty", "azerty", }, {"zoroastre", "azerty", "azerty",}, { "zoroastre", "zoroastre", }, },
      /* zoroastre */ { { "azerty", "azerty", "cromagnon",  },  { "azerty", "azerty", "cromagnon",  }, {}, {}, },
      /* zoroastre */ { { "azerty", "azerty", "cromagnon",  },  { "azerty", "azerty", "cromagnon",  }, {}, {}, },
    };    

    // créer un bloc
    // System.out.println();
    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(donnees);
    for (int id = 0; id < donnees.length; ++id) {
      // découper b1 selon donnees[id]
      // System.out.print("(" + id + ") " + donnees[id] + ": ");
      List<Tableau<String>> lblocs = b1.decouper(new String(donnees[id]));
      Assert.assertTrue("Taille incorrecte (" + lblocs.size() + " au lieu de " + solutions[id].length + ")",
			lblocs.size() == solutions[id].length);
      // vérifier le contenu des sous-blocs
      Iterator<Tableau<String>> it = lblocs.iterator();
      int numsb = 0;
      while (it.hasNext()) {
	Tableau<String> sousbloc = it.next();
	// System.out.print("{");
	// for (int i = 0; i < solutions[id][numsb].length; ++i) {
	//   System.out.print(solutions[id][numsb][i] + ",");
	// }
	// System.out.print("} ");
	verifBloc(sousbloc, solutions[id][numsb]);
	++numsb;
      }
      // System.out.println();
    }
    //  vérifier que b1 n'a pas changé
    verifBloc(b1, donnees);
    System.out.println("Test réussi");
  }

  // Exemple du sujet
  @Test
  public void decouper_sujet()
  {
    System.out.print("\n*** Découper ; exemple du sujet : ");
    int [] donnees = {
      11, 5, 7, 8, 8, 10, 12, 8, 14, 11, 20, 5, 8
    };
    int [][] solutions = {
      {11, 5, 7}, {}, {10, 12}, {14, 11, 20, 5}, {}
    };

    // créer un bloc
    BlockTP<Integer> b1 = (BlockTP<Integer>) initialiserTableau(donnees);
    // découper b1 selon 8
    List<Tableau<Integer>> lblocs = b1.decouper(new Integer(8));
    Assert.assertTrue("Taille incorrecte (" + lblocs.size() + " au lieu de " + solutions.length + ")",
		      lblocs.size() == solutions.length);
    // vérifier le contenu des sous-blocs
    Iterator<Tableau<Integer>> it = lblocs.iterator();
    int numsb = 0;
    while (it.hasNext()) {
      Tableau<Integer> sousbloc = it.next();
      // System.out.print("{");
      // for (int i = 0; i < solutions[numsb].length; ++i) {
      // 	System.out.print(solutions[numsb][i] + ",");
      // }
      // System.out.print("} ");
      verifBloc(sousbloc, solutions[numsb]);
      ++numsb;
    }
    //  vérifier que b1 n'a pas changé
    verifBloc(b1, donnees);
    System.out.println("Test réussi");
  }

  // tous les éléments identiques à l'élément cherché
  @Test
  public void decouper_identiques()
  {
    System.out.print("\n*** Découper ; tous les éléments à l'élément cherché : ");
    String [] donnees = {
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
	"cromagnon",
    };
    String [][] solutions = {
      {},{},{},{},{},{},{},{},
    };

    BlockTP<String> b1 = (BlockTP<String>) initialiserTableau(donnees);
    // découper b1 selon "cromagnon"
    List<Tableau<String>> lblocs = b1.decouper(new String(donnees[0]));
    Assert.assertTrue("Taille incorrecte (" + lblocs.size() + " au lieu de " + solutions.length + ")",
		      lblocs.size() == solutions.length);
    // vérifier le contenu des sous-blocs
    Iterator<Tableau<String>> it = lblocs.iterator();
    int numsb = 0;
    while (it.hasNext()) {
      Tableau<String> sousbloc = it.next();
      // System.out.print("{");
      // for (int i = 0; i < solutions[numsb].length; ++i) {
      // 	System.out.print(solutions[numsb][i] + ",");
      // }
      // System.out.print("} ");
      verifBloc(sousbloc, solutions[numsb]);
      ++numsb;
    }
    //  vérifier que b1 n'a pas changé
    verifBloc(b1, donnees);
    System.out.println("Test réussi");
  }

  //  vérifier la taille et le contenu d'un bloc
  void verifBloc(Tableau<Integer>bloc, int [] tch)
  {
    Assert.assertTrue("Taille bloc incorrecte (" + bloc.size() + " au lieu de " + tch.length + ")",
	bloc.size() == tch.length);
    for (int i = 0; i < tch.length; ++i) {
      Assert.assertTrue("Valeur incorrecte (" + bloc.get(i) + " au lieu de " + tch[i] + ")",
	  bloc.get(i).equals(tch[i]));
    }
  }
  //  vérifier la taille et le contenu d'un bloc
  void verifBloc(Tableau<String>bloc, String [] tch)
  {
    Assert.assertTrue("Taille bloc incorrecte (" + bloc.size() + " au lieu de " + tch.length + ")",
	bloc.size() == tch.length);
    for (int i = 0; i < tch.length; ++i) {
      Assert.assertTrue("Valeur incorrecte (" + bloc.get(i) + " au lieu de " + tch[i] + ")",
      bloc.get(i).equals(tch[i]));
    }
  }
  //  vérifier la taille et le contenu d'un bloc
  // les éléments du bloc doivent être égaux aux nbElem éléments du tableau à partir de l'indice debut
  void verifBloc(Tableau<String>bloc, String [] tch, int debut, int nbElem)
  {
    Assert.assertTrue("Taille bloc incorrecte (" + bloc.size() + " au lieu de " + nbElem + ")",
	bloc.size() == nbElem);
    for (int i = 0; i < nbElem; ++i) {
      Assert.assertTrue("Valeur incorrecte (" + bloc.get(i) + " au lieu de " + tch[i+debut] + ")",
	  bloc.get(i).equals(tch[i+debut]));
    }
  }
}
