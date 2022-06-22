package com.banking.banca.model.service;

import com.banking.banca.model.document.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
    Flux<Movement> getAll();

    Mono<Movement> save(Movement movement);

    Mono<Movement> update(String id, Movement movement);

    Mono<Movement> findById(String id);
    Mono<Void> delete(String id);
}
