package com.banking.banca.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class ApiExceptionResponse.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiExceptionResponse {
  private Date date;
  private String errorMessage;
  private String path;
}
