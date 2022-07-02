package com.banking.banca.model.service;

import com.banking.banca.model.document.Client;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * interface ClientService.
 */
public interface ClientService {
  Mono<List<Client>> getAll();

  Mono<Client> save(Client client);

  Mono<Client> update(Client client);

  Mono<Void> deleteById(String id);

  Mono<Client> findById(String id);

}
