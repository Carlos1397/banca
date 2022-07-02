package com.banking.banca.model.repository;

import com.banking.banca.model.document.Passive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * interface PassiveRepository.
 */
@Repository
public interface PassiveRepository extends ReactiveMongoRepository<Passive, String> {

  Mono<Passive> findByTypeAccount(String account);

}
