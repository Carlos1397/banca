package com.banking.banca.api;


import com.banking.banca.exception.MyException;
import com.banking.banca.model.document.Movement;
import com.banking.banca.model.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class MovementController.
 */

@RestController
@RequestMapping("/api/v1/movements")
public class MovementController {
  @Autowired
  private MovementService movementService;

  /**
   * Method Register Movement.
   *
   * @param movement *
   * @return movement
   */
  @PostMapping()
  public Mono<Movement> register(@RequestBody Movement movement) {
    if (movement.getCodPassive() == null || movement.getCodPassive().isEmpty()) {
      throw new MyException(HttpStatus.BAD_REQUEST, "error in idPassive");
    } else {
      return movementService.save(movement);
    }
  }

  @GetMapping()
  public Flux<Movement> getAllMovement() {
    return movementService.getAll();
  }

  @GetMapping("/{id}")
  public Mono<Movement> getMovement(@PathVariable String id) {
    return movementService.findById(id);
  }
}
