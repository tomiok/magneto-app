package org.tomas.testmlib.component.search.column;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColumnConfig {

  @Bean
  public ColumnComponent columnSearchComponent() {
    return new ColumnComponentImpl();
  }
}
