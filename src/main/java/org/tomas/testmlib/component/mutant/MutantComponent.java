package org.tomas.testmlib.component.mutant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface MutantComponent {

  boolean isMutant(final String[] dna);

  void saveDna(final String dna, final boolean mutant);

  MutantStat mutantsStatistics();

  @Getter
  @Setter
  @AllArgsConstructor
  class MutantStat {

    private final long countMutantDna;
    private final long countHumanDna;
    private final float ratio;
  }
}
