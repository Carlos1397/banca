package com.banking.banca.model.repository;

import com.banking.banca.model.document.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends ReactiveMongoRepository<Movement,String> {
}
