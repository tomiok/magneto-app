package org.tomas.testmlib.component.search.row;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RowComponentConfig {

  @Bean
  public RowComponent rowComponent() {
    return new RowComponentImpl();
  }
}
