package com.banking.banca.model.document;

import com.banking.banca.model.document.enums.TypeCard;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * Class Card.
 */
@Document(collection = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
  @Id
  private String id;

  private String nroCard;

  private double approvedLine;

  private double availableBalance;

  private TypeCard typeCard;

  private double usage;   // consumo

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date createdDate = new Date();

}
