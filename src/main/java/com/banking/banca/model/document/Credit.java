package com.banking.banca.model.document;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;



/**
 * Class Credits.
 */
@Document(collection = "credits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
  @Id
  private String id;

  private double capital;


  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date createdDate = new Date();
}
