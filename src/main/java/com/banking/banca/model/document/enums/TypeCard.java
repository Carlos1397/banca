package com.banking.banca.model.document.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * enum TypeCard.
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeCard {
  DEBIT("DEBIT"), CREDIT("CREDIT");
  // ENUM TYPE: "DEBIT", "CREDIT"
  private String name;
}
