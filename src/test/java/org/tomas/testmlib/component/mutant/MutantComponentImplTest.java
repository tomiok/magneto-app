package org.tomas.testmlib.component.mutant;

import static org.mockito.Matchers.any;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.tomas.testmlib.component.search.column.ColumnComponent;
import org.tomas.testmlib.component.search.diagonal.DiagonalComponent;
import org.tomas.testmlib.component.search.row.RowComponent;
import org.tomas.testmlib.domain.Dna;
import org.tomas.testmlib.domain.DnaRepository;

@RunWith(SpringRunner.class)
public class MutantComponentImplTest {

  private static final String[] DNA = { "ATGCGA", "CAGTGC", "TCATGT", "AGCAGG", "CCCCTA", "TCACTG" };

  @MockBean
  private RowComponent rowComponent;

  @MockBean
  private ColumnComponent columnComponent;

  @MockBean
  private DiagonalComponent diagonalComponent;

  @MockBean
  private DnaRepository dnaRepository;

  private MutantComponent mutantComponent;

  @Before
  public void setUp() {
    mutantComponent = new MutantComponentImpl(columnComponent, rowComponent, diagonalComponent, dnaRepository);
  }

  @Test
  public void isMutant() {
    Mockito.when(rowComponent.countMutantSequencesInRows(any(String[].class))).thenReturn(1L);
    Mockito.when(columnComponent.countMutantSequencesInColumns(any(String[].class))).thenReturn(1L);
    Mockito.when(diagonalComponent.countMutantSequencesInDiagonals(any(String[].class))).thenReturn(0L);

    boolean isMutant = mutantComponent.isMutant(DNA);

    Assertions.assertThat(isMutant).isTrue();
  }

  @Test
  public void notMutant() {
    Mockito.when(rowComponent.countMutantSequencesInRows(any(String[].class))).thenReturn(0L);
    Mockito.when(columnComponent.countMutantSequencesInColumns(any(String[].class))).thenReturn(1L);
    Mockito.when(diagonalComponent.countMutantSequencesInDiagonals(any(String[].class))).thenReturn(0L);

    boolean isMutant = mutantComponent.isMutant(DNA);

    Assertions.assertThat(isMutant).isFalse();
  }

  @Test
  public void shouldReturnMutantStats() {
    Mockito.when(dnaRepository.findAll()).thenReturn(Arrays.asList(new Dna("dna", true), new Dna("dna2", true),
        new Dna("dna3", false)));

    MutantComponent.MutantStat stat = mutantComponent.mutantsStatistics();

    Assertions.assertThat(stat.getCountHumanDna()).isEqualTo(1);
    Assertions.assertThat(stat.getCountMutantDna()).isEqualTo(2);
    Assertions.assertThat(stat.getRatio()).isEqualTo(2);
  }
}