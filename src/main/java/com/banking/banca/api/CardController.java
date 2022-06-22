package com.banking.banca.api;

import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Asset;
import com.banking.banca.model.document.Card;
import com.banking.banca.model.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        return  cardService.save(card);
    }

    @GetMapping("/{id}")
    public Mono<Card> getCard(@PathVariable String id) {
        return  cardService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCard(@PathVariable String id) {
       return  cardService.delete(id);
    }
    @PutMapping("/{id}")
    public Mono<Card> updateCard(@PathVariable String id, @RequestBody Card card) {
        return  cardService.update(id,card);
    }


}
