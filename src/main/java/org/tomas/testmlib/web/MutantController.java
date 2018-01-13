package org.tomas.testmlib.web;

import static java.util.Arrays.deepToString;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tomas.testmlib.component.mutant.MutantComponent;

@RestController
@RequestMapping("/api")
public class MutantController {

  private final MutantComponent mutantComponent;

  @Autowired
  public MutantController(final MutantComponent mutantComponent) {
    this.mutantComponent = mutantComponent;
  }

  @PostMapping("/mutant")
  public ResponseEntity<?> checkAndSaveMutant(@RequestBody final MutantHttpRequest request) {
    String[] dna = request.getDna();
    boolean mutant = mutantComponent.isMutant(dna);
    mutantComponent.saveDna(deepToString(dna), mutant);
    return mutant ? ok().build() : status(HttpStatus.FORBIDDEN).build();
  }

  @GetMapping("/stats")
  public ResponseEntity<MutantStatisticsHttpResponse> getStats() {
    return ok(new MutantStatisticsHttpResponse(mutantComponent.mutantsStatistics()));
  }
}
