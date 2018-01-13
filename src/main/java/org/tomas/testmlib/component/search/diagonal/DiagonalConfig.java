package org.tomas.testmlib.component.search.diagonal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiagonalConfig {

  @Bean
  public DiagonalComponent diagonalComponent() {
    return new DiagonalComponentImpl();
  }
}
