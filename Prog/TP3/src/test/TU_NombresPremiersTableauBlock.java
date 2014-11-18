package test;

import tableau.TableauBlock;
import tableau.Tableau;

public class TU_NombresPremiersTableauBlock extends TU_NombresPremiersBlock {

  // création de tableau
  public Tableau<Integer> makeTableau(int capinit) {
    return new TableauBlock<Integer>(capinit);
  }
}
