package com.banking.banca.service;

import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Passive;
import com.banking.banca.model.repository.PassiveRepository;
import com.banking.banca.model.service.PassiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PassiveServiceImpl implements PassiveService {
    @Autowired
    private PassiveRepository passiveRepository;

    @Override
    public Flux<Passive> getAll() {
        return passiveRepository.findAll();
    }

    @Override
    public Mono<Passive> save(Passive passive) {
       return passiveRepository.save(passive);
    }

    @Override
    public Mono<Passive> update(Passive passive) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Passive> findById(String id) {
        return passiveRepository.findById(id);
    }


}
