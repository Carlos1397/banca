package com.banking.banca.api;

import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Passive;
import com.banking.banca.model.service.PassiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Slf4j
@RequestMapping("/api/v1/passives")
public class PassiveController {
    @Autowired
    private PassiveService passiveService;


    @PostMapping()
    public Mono<Passive> createPassive(@RequestBody Passive passive) {
        log.info(passive.getTypeAccount().getName());
        if(passive.getClient()==null ||passive.getClient().isEmpty()){
            throw new MyException(HttpStatus.BAD_REQUEST,"error in idClient");
        }else {
            return passiveService.save(passive);
        }
    }

    @GetMapping()
    public Flux<Passive> getAllClients() {
        return passiveService.getAll();
    }


    @GetMapping("/{id}")
    public Mono<Passive> getClientID(@PathVariable String id) {
     return  passiveService.findById(id);
    }
}
