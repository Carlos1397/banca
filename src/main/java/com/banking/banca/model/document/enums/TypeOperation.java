package com.banking.banca.model.document.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * enum TypeOperation.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TypeOperation {
  WITHDRAWAL("WITHDRAWAL"), DEPOSIT("DEPOSIT"); // ENUM TYPE: "WITHDRAWAL" Y "DEPOSIT"
  private String name;
}
