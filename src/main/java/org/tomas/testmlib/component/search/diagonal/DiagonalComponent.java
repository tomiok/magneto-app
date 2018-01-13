package org.tomas.testmlib.component.search.diagonal;

public interface DiagonalComponent {

  /**
   *
   * @param dna The person DNA.
   * @return Number of sequences found in the given DNA.
   */
  long countMutantSequencesInDiagonals(final String[] dna);
}
