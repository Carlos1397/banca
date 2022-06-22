package com.banking.banca.model.service;

import com.banking.banca.model.document.Client;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClientService {
    Mono<List<Client>> getAll();
    Mono<Client> save(Client client);
    Mono<Client> update(Client client);
    Mono<Void> deleteById(String id);
    Mono<Client> findById(String id);

}
