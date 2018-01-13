package org.tomas.testmlib.component.search.row;

public interface RowComponent {

  /**
   * @param dna The person DNA.
   * @return the number of sequences that match with the pattern.
   */
  long countMutantSequencesInRows(final String[] dna);
}
