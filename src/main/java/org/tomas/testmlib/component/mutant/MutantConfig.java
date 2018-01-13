package org.tomas.testmlib.component.mutant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tomas.testmlib.component.search.column.ColumnComponent;
import org.tomas.testmlib.component.search.diagonal.DiagonalComponent;
import org.tomas.testmlib.component.search.row.RowComponent;
import org.tomas.testmlib.domain.DnaRepository;

@Configuration
public class MutantConfig {

  @Autowired
  private RowComponent rowComponent;

  @Autowired
  private ColumnComponent columnComponent;

  @Autowired
  private DiagonalComponent diagonalComponent;

  @Autowired
  private DnaRepository dnaRepository;

  @Bean
  public MutantComponent mutantComponent() {
    return new MutantComponentImpl(columnComponent, rowComponent, diagonalComponent, dnaRepository);
  }
}
