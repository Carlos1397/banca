package com.banking.banca.service;

import com.banking.banca.model.document.Movement;
import com.banking.banca.model.repository.MovementRepository;
import com.banking.banca.model.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Flux<Movement> getAll() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<Movement> save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public Mono<Movement> update(String id, Movement movement) {
        return null;
    }

    @Override
    public Mono<Movement> findById(String id) {
        return movementRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return movementRepository.deleteById(id);
    }
}
