package com.banking.banca.model.service;

import com.banking.banca.model.document.Asset;
import com.banking.banca.model.document.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<Card> getAll();

    Mono<Card> save(Card card);

    Mono<Card> update(String id, Card card);

    Mono<Card> findById(String id);
    Mono<Void> delete(String id);
}
