package com.banking.banca.model.service;

import com.banking.banca.model.document.Asset;
import com.banking.banca.model.document.Card;
import com.banking.banca.model.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<Credit> getAll();

    Mono<Credit> save(Credit credit);

    Mono<Credit> update(String id, Credit credit);

    Mono<Credit> findById(String id);
    Mono<Void> delete(String id);

}
