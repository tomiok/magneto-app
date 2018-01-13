package org.tomas.testmlib.component.mutant;

import java.util.List;
import org.apache.commons.lang3.Validate;
import org.tomas.testmlib.component.search.column.ColumnComponent;
import org.tomas.testmlib.component.search.diagonal.DiagonalComponent;
import org.tomas.testmlib.component.search.row.RowComponent;
import org.tomas.testmlib.domain.Dna;
import org.tomas.testmlib.domain.DnaRepository;

class MutantComponentImpl implements MutantComponent {

  private final ColumnComponent columnComponent;

  private final RowComponent rowComponent;

  private final DiagonalComponent diagonalComponent;

  private final DnaRepository dnaRepository;

  MutantComponentImpl(final ColumnComponent columnComponent,
                      final RowComponent rowComponent,
                      final DiagonalComponent diagonalComponent,
                      final DnaRepository dnaRepository) {

    Validate.notNull(columnComponent);
    Validate.notNull(rowComponent);
    Validate.notNull(diagonalComponent);
    Validate.notNull(dnaRepository);

    this.columnComponent = columnComponent;
    this.rowComponent = rowComponent;
    this.diagonalComponent = diagonalComponent;
    this.dnaRepository = dnaRepository;
  }

  @Override
  public boolean isMutant(final String[] dna) {
    long partialCount = 0;

    long diagonals = diagonalComponent.countMutantSequencesInDiagonals(dna);
    partialCount += diagonals;

    if (isAlreadyMutant(partialCount)) {
      return true;
    }

    long rows = rowComponent.countMutantSequencesInRows(dna);
    partialCount += rows;

    if (isAlreadyMutant(partialCount)) {
      return true;
    }

    long columns = columnComponent.countMutantSequencesInColumns(dna);
    partialCount += columns;

    return isAlreadyMutant(partialCount);
  }

  @Override
  public void saveDna(final String dna, final boolean mutant) {
    dnaRepository.save(new Dna(dna, mutant));
  }

  @Override
  public MutantStat mutantsStatistics() {
    return calculate(dnaRepository.findAll());
  }

  private MutantStat calculate(List<Dna> dnas) {

    long mutants = dnas
        .stream()
        .filter(Dna::isMutant)
        .count();

    long humans = dnas.size() - mutants;

    double ratio = mutants / humans;
    return new MutantStat(mutants, humans, ratio);

  }

  private boolean isAlreadyMutant(long count) {
    return count > 1;
  }
}
