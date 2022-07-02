package com.banking.banca.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * class MyException.
 */
@Getter
@Setter
public class MyException extends ResponseStatusException {
  private String message;

  public MyException(HttpStatus status) {
    super(status);
  }

  public MyException(HttpStatus status, String message) {
    super(status);
    this.message = message;
  }


}
