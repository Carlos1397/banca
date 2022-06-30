package com.banking.banca.model.document;

import com.banking.banca.model.document.enums.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "passives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passive {

    @Id
    private String id;

    private TypeAccount typeAccount;

    private double commission; // comision

    private Integer limitMov; //limite de movimientos

    private double balance; //saldo

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate = new Date();

    public String client;

    boolean isTypeAccountExiste(){
        return !this.typeAccount.equals(null);
    }

}
