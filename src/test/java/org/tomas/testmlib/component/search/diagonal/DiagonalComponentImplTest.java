package org.tomas.testmlib.component.search.diagonal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DiagonalComponentImplTest {

  private DiagonalComponent component = new DiagonalComponentImpl();

  @Test
  public void countMutantSequencesInDiagonals_oneFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInDiagonals(dna);
    Assertions.assertThat(count).isEqualTo(1);
  }

  @Test
  public void countMutantSequencesInDiagonals_twoFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TCATGT", "AGCAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInDiagonals(dna);
    // C and A are in this matrix
    Assertions.assertThat(count).isEqualTo(2);
  }
}