package com.banking.banca.model.repository;

import com.banking.banca.model.document.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * interface CardRepository.
 */
@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {

}
