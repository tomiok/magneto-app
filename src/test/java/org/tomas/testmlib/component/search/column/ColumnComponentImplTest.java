package org.tomas.testmlib.component.search.column;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ColumnComponentImplTest {

  private ColumnComponent component = new ColumnComponentImpl();

  @Test
  public void countMutantSequencesInColumns_oneFound() {
    String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInColumns(dna);
    Assertions.assertThat(count).isEqualTo(1);
  }

  @Test
  public void countMutantSequencesInColumns_noneFound() {
    String[] dna = { "ATGCGA", "CAGTCC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInColumns(dna);
    Assertions.assertThat(count).isEqualTo(0);
  }

  @Test
  public void countMutantSequencesInColumns_twoFound() {
    String[] dna = { "ATGCGA", "CAGTGA", "TTATGA", "AGAAGA", "CCCCTA", "TCACTG" };
    long count = component.countMutantSequencesInColumns(dna);
    Assertions.assertThat(count).isEqualTo(2);
  }
}