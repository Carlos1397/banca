package com.banking.banca.api;

import com.banking.banca.model.document.Credit;
import com.banking.banca.model.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class CreditController.
 */
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
    return creditService.save(credit);
  }
}
