package com.fabric.fruts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @PrimaryKey("product_id")
    private Integer id;
    private String title;

}
