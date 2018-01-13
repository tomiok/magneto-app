package org.tomas.testmlib.component.search.diagonal;

public interface DiagonalComponent {

  /**
   * @param dna The person DNA.
   * @return the number of sequences that match with the pattern.
   */
  long countMutantSequencesInDiagonals(final String[] dna);
}
