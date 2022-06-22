package com.banking.banca.model.repository;

import com.banking.banca.model.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {


}
