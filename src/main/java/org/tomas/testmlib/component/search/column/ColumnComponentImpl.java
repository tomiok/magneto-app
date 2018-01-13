package org.tomas.testmlib.component.search.column;

import static org.tomas.testmlib.component.search.DnaUtils.A;
import static org.tomas.testmlib.component.search.DnaUtils.C;
import static org.tomas.testmlib.component.search.DnaUtils.G;
import static org.tomas.testmlib.component.search.DnaUtils.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class ColumnComponentImpl implements ColumnComponent {

  private static final Predicate<String> MUTANT_SEQUENCE_PREDICATE =
      s -> s.contains(A.getSequence()) || s.contains(C.getSequence())
           || s.contains(G.getSequence()) || s.contains(T.getSequence());

  @Override
  public long countMutantSequencesInColumns(final String[] dna) {
    char[][] matrix = toMatrix(dna);
    int length = matrix.length;

    return getColumns(matrix, length)
        .stream()
        .map(this::toStringFromCharArray)
        .filter(MUTANT_SEQUENCE_PREDICATE)
        .count();
  }

  private List<char[]> getColumns(final char[][] matrix, final int length) {
    return new ArrayList<>(Arrays.asList(reverseArray(matrix)).subList(0, length));
  }

  private char[][] reverseArray(final char[][] matrix) {
    int matrixLength = matrix.length;
    char[][] reversed = new char[matrixLength][matrixLength];
    for (int i = 0; i < matrixLength; i++) {
      for (int j = 0; j < matrixLength; j++) {
        reversed[i][j] = matrix[j][i];
      }
    }
    return reversed;
  }

  private String toStringFromCharArray(final char[] charArray) {
    return new String(charArray);
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
