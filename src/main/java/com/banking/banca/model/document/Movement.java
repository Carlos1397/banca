package com.banking.banca.model.document;

import com.banking.banca.model.document.enums.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement {
    @Id
    private String id;

    private double amount; //


    private TypeOperation typeOperation;

    private String codPassive;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate = new Date();
}
