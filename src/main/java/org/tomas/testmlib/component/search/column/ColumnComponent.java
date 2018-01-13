package org.tomas.testmlib.component.search.column;

public interface ColumnComponent {

  /**
   * @param dna The person DNA.
   * @return the number of sequences that match with the pattern.
   */
  long countMutantSequencesInColumns(final String[] dna);
}
