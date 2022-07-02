package com.banking.banca.api;


import com.banking.banca.model.document.Client;
import com.banking.banca.model.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class ClientController.
 */
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
    return clientService.update(client);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteClient(@PathVariable String id) {
    return clientService.deleteById(id);
  }
}
