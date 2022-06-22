package com.banking.banca.api;

import com.banking.banca.model.document.Client;
import com.banking.banca.model.document.Movement;
import com.banking.banca.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping()
    public Mono<Client> register(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping()
    public Mono<List<Client>> getAllClients() {
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Mono<Client> getClient(@PathVariable String id) {
        return clientService.findById(id);
    }
    @PutMapping()
    public Mono<Client> updateClient(@RequestBody Client client) {
        return  clientService.update(client);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteClient(@PathVariable String id) {
        return  clientService.deleteById(id);
    }
}
