package com.banking.banca.api;


import com.banking.banca.model.document.Card;
import com.banking.banca.model.document.Credit;
import com.banking.banca.model.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping()
    public Flux<Credit> getAllCredit() {
        return creditService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> getCredit(@PathVariable String id) {
        return creditService.findById(id);
    }

    @PostMapping
    public Mono<Credit> register(@RequestBody Credit credit) {
      return  creditService.save(credit);
    }
}
