package com.banking.banca.model.document;

import com.banking.banca.model.document.enums.TypeClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private String id;

    private String name;

    private String nroDocument;


    private TypeClient typeClient;

}
