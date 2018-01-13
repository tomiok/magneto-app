package org.tomas.testmlib.component.search.row;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RowComponentImplTest {

  private RowComponent component = new RowComponentImpl();

  @Test
  public void countMutantSequencesInRows_oneFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInRows(dna);
    Assertions.assertThat(count).isEqualTo(1);
  }

  @Test
  public void countMutantSequencesInRows_noneFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInRows(dna);
    Assertions.assertThat(count).isEqualTo(0);
  }

  @Test
  public void countMutantSequencesInRows_twoFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TTTTGT", "AGAAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInRows(dna);
    Assertions.assertThat(count).isEqualTo(2);
  }
}