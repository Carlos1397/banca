package com.banking.banca.service;

import com.banking.banca.model.document.Card;
import com.banking.banca.model.repository.CardRepository;
import com.banking.banca.model.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * class CardServiceImpl.
 */
@Service
public class CardServiceImpl implements CardService {
  @Autowired
  private CardRepository cardRepository;

  @Override
  public Flux<Card> getAll() {
    return cardRepository.findAll();
  }

  @Override
  public Mono<Card> save(Card card) {
    return cardRepository.save(card);
  }

  @Override
  public Mono<Card> update(String id, Card card) {
    return cardRepository.findById(id)
                         .switchIfEmpty(Mono.error(new Exception("CLIENT_NOT_FOUND")))
                         .map(p -> {
                           card.setId(id);
                           if (card.getApprovedLine() >= 0) {
                             card.setApprovedLine(card.getApprovedLine());
                           }
                           if (card.getAvailableBalance() >= 0) {
                             card.setAvailableBalance(card.getAvailableBalance());
                           }
                           return card;
                         })
                         .flatMap(cardRepository::save);
  }

  @Override
  public Mono<Card> findById(String id) {
    return cardRepository.findById(id);
  }

  @Override
  public Mono<Void> delete(String id) {
    return cardRepository.deleteById(id);
  }
}
