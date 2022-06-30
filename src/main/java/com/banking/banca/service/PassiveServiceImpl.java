package com.banking.banca.service;

import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Client;
import com.banking.banca.model.document.Passive;
import com.banking.banca.model.repository.PassiveRepository;
import com.banking.banca.model.service.ClientService;
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
    @Autowired
    private ClientService clientService;

    @Override
    public Flux<Passive> getAll() {
        return passiveRepository.findAll();
    }

    @Override
    public Mono<Passive> save(Passive passive) {
        Mono<Passive> passiveMono = null;
        if(clientService.findById(passive.getClient()).block().getTypeClient().getName().equals("STAFF")){
            try{
                if(!passiveRepository.findByTypeAccount(passive.getTypeAccount().getName()).block().equals(null)){
                  throw new MyException(HttpStatus.BAD_REQUEST,"Cuenta ya exite!");
                }
            }catch(NullPointerException exception){
                passiveMono = passiveRepository.save(passive);
                log.info("Agregado"+passive.getClient());
            }
        }
        if (clientService.findById(passive.getClient()).block().getTypeClient().getName().equals("BUSINESS")){
            if(!passive.getTypeAccount().getName().equals("CURRENT")){
                throw new MyException(HttpStatus.BAD_REQUEST,"no puede ser!");
            }else{
                passiveMono = passiveRepository.save(passive);
                log.info("SE VA HA AGREGADO");
            }


        }
    return passiveMono;
    }

    @Override
    public Mono<Passive> update(Passive passive) {
        return passiveRepository.save(passive) ;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return passiveRepository.deleteById(id);
    }

    @Override
    public Mono<Passive> findById(String id) {
        return passiveRepository.findById(id);
    }


}
