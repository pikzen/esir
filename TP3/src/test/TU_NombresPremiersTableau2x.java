package test;

import tableau.Tableau2x;
import tableau.Tableau;

public class TU_NombresPremiersTableau2x extends TU_NombresPremiersBlock {

  // création de tableau
  public Tableau<Integer> makeTableau(int capinit) {
    return new Tableau2x<Integer>(capinit);
  }
}
