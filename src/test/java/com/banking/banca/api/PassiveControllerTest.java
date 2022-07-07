package com.banking.banca.api;

import com.banking.banca.model.document.Passive;
import com.banking.banca.model.repository.PassiveRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static com.banking.banca.model.document.enums.TypeAccount.CURRENT;
import static com.banking.banca.model.document.enums.TypeAccount.SAVINGS;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassiveControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @Test
  public void tGetPassiveId() {
    webTestClient.get()
                 .uri("/api/v1/passives/{id}", "62c6767daf1ebf4c2a2805e7")
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody()
                 .consumeWith(response ->
                     Assertions.assertNotNull(response.getResponseBody()))
                 .jsonPath("$.typeAccount").isEqualTo("SAVINGS")
                 .jsonPath("$.balance").isEqualTo(500);

  }

}
