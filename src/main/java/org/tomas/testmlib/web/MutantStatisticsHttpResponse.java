package org.tomas.testmlib.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.tomas.testmlib.component.mutant.MutantComponent;

@Getter
class MutantStatisticsHttpResponse {

  @JsonProperty("count_human_dna")
  private long humans;

  @JsonProperty("count_mutant_dna")
  private long mutants;

  private float ratio;

  MutantStatisticsHttpResponse(final MutantComponent.MutantStat stats) {
    this.humans = stats.getCountHumanDna();
    this.mutants = stats.getCountMutantDna();
    this.ratio = stats.getRatio();
  }
}
