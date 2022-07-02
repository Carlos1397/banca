package com.banking.banca.api;

import com.banking.banca.model.document.Passive;
import com.banking.banca.model.service.PassiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * class PassiveController.
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/passives")
public class PassiveController {
  @Autowired
  private PassiveService passiveService;

  /**
   * Method Register Movement.
   *
   * @param passive *
   * @return passive
   */
  @PostMapping()
  public Mono<Passive> createPassive(@RequestBody Passive passive) {
    return passiveService.save(passive);
  }

  @GetMapping()
  public Flux<Passive> getAllPassive() {
    return passiveService.getAll();
  }


  @GetMapping("/{id}")
  public Mono<Passive> getPassiveId(@PathVariable String id) {
    return passiveService.findById(id);
  }

  @PutMapping()
  public Mono<Passive> updatePassive(@RequestBody Passive passive) {
    return passiveService.update(passive);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deletePassive(@PathVariable String id) {
    return passiveService.deleteById(id);
  }
}
