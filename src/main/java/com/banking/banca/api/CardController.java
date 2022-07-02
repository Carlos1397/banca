package com.banking.banca.api;

import com.banking.banca.model.document.Card;
import com.banking.banca.model.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class CardController.
 */
@RestController
@RequestMapping("/api/v1/cards")
public class CardController {
  @Autowired
  private CardService cardService;

  @GetMapping()
  public Flux<Card> getAllCard() {
    return cardService.getAll();
  }

  @PostMapping
  public Mono<Card> register(@RequestBody Card card) {
    return cardService.save(card);
  }

  @GetMapping("/{id}")
  public Mono<Card> getCard(@PathVariable String id) {
    return cardService.findById(id);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteCard(@PathVariable String id) {
    return cardService.delete(id);
  }

  @PutMapping("/{id}")
  public Mono<Card> updateCard(@PathVariable String id, @RequestBody Card card) {
    return cardService.update(id, card);
  }


}
