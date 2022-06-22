package com.banking.banca.model.service;

import com.banking.banca.model.document.Asset;
import com.banking.banca.model.document.Passive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssetService {
    Flux<Asset> getAll();

    Mono<Asset> save(Asset asset);

    Mono<Asset> update(String id, Asset asset);

    Mono<Asset> findById(String id);

    Mono<Void> delete(String id);
}
