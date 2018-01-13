package org.tomas.testmlib.component.search.diagonal;

import org.tomas.testmlib.component.search.DnaUtils;

class DiagonalComponentImpl implements DiagonalComponent {

  private static final DnaUtils[] sequences = DnaUtils.values();
  private static final int SIZE = sequences.length;
  private static final int STRING_LENGTH = 4;

  @Override
  public long countMutantSequencesInDiagonals(final String[] dna) {
    char[][] matrix = toMatrix(dna);
    boolean strFound;
    int matrixLength = matrix.length;
    int maxBuckets = matrixLength - STRING_LENGTH;
    long count = 0;
    for (int i = 0; i < SIZE; i++) {
      char[] searchStr = sequences[i].getSequence().toCharArray();
      for (int row = 0; row < maxBuckets; row++) {
        for (int col = 0; col < maxBuckets; col++) {
          strFound = true; // consider the string found
          for (int k = 0; k < STRING_LENGTH; k++) {
            if (searchStr[k] != matrix[row + k][col + k]) {
              strFound = false;
              break;
            }
          }
          if (strFound) {
            count++;
          }
        }
      }
    }

    return count;
  }

  private char[][] toMatrix(final String[] dna) {
    int dnaLength = dna.length;
    char[][] matrix = new char[dnaLength][dnaLength];

    for (int i = 0; i < dna.length; i++) {
      matrix[i] = dna[i].toCharArray();
    }
    return matrix;
  }

}
