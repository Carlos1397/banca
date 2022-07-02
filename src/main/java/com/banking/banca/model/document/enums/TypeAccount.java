package com.banking.banca.model.document.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * enum TypeAccount.
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeAccount {
  SAVINGS("SAVINGS"), CURRENT("CURRENT"), FIXED("FIXED");
  // ENUM TYPE: "SAVINGS ACCOUNT", "CURRENT ACCOUNT","FIXED TERM ACCOUNT"
  private String name;

}
