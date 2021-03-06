package com.banking.banca.service;

import com.banking.banca.model.document.Credit;
import com.banking.banca.model.repository.CreditRepository;
import com.banking.banca.model.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Class CreditServiceImpl.
 */
@Service
public class CreditServiceImpl implements CreditService {
  @Autowired
  private CreditRepository creditRepository;

  @Override
  public Flux<Credit> getAll() {
    return creditRepository.findAll();
  }

  @Override
  public Mono<Credit> save(Credit credit) {
    return creditRepository.save(credit);
  }

  @Override
  public Mono<Credit> update(String id, Credit credit) {
    return null;
  }

  @Override
  public Mono<Credit> findById(String id) {
    return creditRepository.findById(id);
  }

  @Override
  public Mono<Void> delete(String id) {
    return creditRepository.deleteById(id);
  }
}
