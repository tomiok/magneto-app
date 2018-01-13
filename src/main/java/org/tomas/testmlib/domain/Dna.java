package org.tomas.testmlib.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Dna {

  @Id
  @GeneratedValue
  private Long id;

  private String dna;

  private boolean mutant;
}
