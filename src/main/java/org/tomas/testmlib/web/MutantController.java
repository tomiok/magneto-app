package org.tomas.testmlib.web;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tomas.testmlib.component.mutant.MutantComponent;

@RestController
public class MutantController {

  private final MutantComponent mutantComponent;

  @Autowired
  public MutantController(final MutantComponent mutantComponent) {
    this.mutantComponent = mutantComponent;
  }

  @PostMapping("/mutant")
  public ResponseEntity checkMutant(@RequestBody final MutantHttpRequest request) {
    boolean mutant = mutantComponent.isMutant(request.getDna());

    System.out.println(Arrays.deepToString(request.getDna()));
    return mutant ? ok().build() : status(HttpStatus.FORBIDDEN).build();
  }
}
