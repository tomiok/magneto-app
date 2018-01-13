package org.tomas.testmlib.component.search.row;

public interface RowComponent {

  /**
   *
   * @param dna The DNA of the person
   * @return The number of sequences which have more than 4 repeated letters.
   */
  long countMutantSequencesInRows(final String[] dna);
}
