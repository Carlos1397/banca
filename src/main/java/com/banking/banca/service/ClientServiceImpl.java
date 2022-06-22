package com.banking.banca.service;

import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Client;
import com.banking.banca.model.repository.ClientRepository;
import com.banking.banca.model.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Mono<List<Client>> getAll() {
        return clientRepository.findAll().collectList().flatMap(p->{
            if(p.isEmpty()){
                throw new MyException(HttpStatus.OK,"List Empty");
            }
            else {
                return Mono.just(p);
            }
        });

    }
    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client) ;
    }

    @Override
    public Mono<Client> update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return clientRepository.deleteById(id);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }


}
