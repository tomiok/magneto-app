package org.tomas.testmlib.component.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DnaUtils {
  A("AAAA"),
  C("CCCC"),
  G("GGGG"),
  T("TTTT");
  private String sequence;
}
