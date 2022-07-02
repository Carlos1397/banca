package com.banking.banca.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class Asset.
 */
@Document(collection = "assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
  @Id
  private String id;
  private String idCard;
  private String[] idCredit;
}
