package org.tomas.testmlib.component.search.row;

import static org.tomas.testmlib.component.search.DnaUtils.A;
import static org.tomas.testmlib.component.search.DnaUtils.C;
import static org.tomas.testmlib.component.search.DnaUtils.G;
import static org.tomas.testmlib.component.search.DnaUtils.T;

class RowComponentImpl implements RowComponent {

  @Override
  public long countMutantSequencesInRows(final String[] dna) {
    long count = 0;
    for (final String sequence : dna) {
      if (sequence.contains(A.getSequence()) || sequence.contains(C.getSequence()) ||
          sequence.contains(G.getSequence()) || sequence.contains(T.getSequence())) {
        count++;
      }
    }

    return count;
  }
}
