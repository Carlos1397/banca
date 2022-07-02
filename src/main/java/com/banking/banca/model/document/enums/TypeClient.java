package com.banking.banca.model.document.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * enum TypeClient.
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeClient {
  STAFF("STAFF"), BUSINESS("BUSINESS"); // ENUM TYPE: "PERSONAL" Y "EMPRESARIAL"
  private String name;
}
