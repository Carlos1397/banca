package com.banking.banca.model.service;

import com.banking.banca.model.document.Passive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * interface PassiveService.
 */
public interface PassiveService {
  Flux<Passive> getAll();

  Mono<Passive> save(Passive passive);

  Mono<Passive> update(Passive passive);

  Mono<Void> deleteById(String id);

  Mono<Passive> findById(String id);


}
