package com.fabric.fruts.controller;

import com.fabric.fruts.entity.Product;
import com.fabric.fruts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/products")
    public Flux<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/product/{id}")
    public Mono<Void> deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @PutMapping("product/{id}")
    public Mono<ResponseEntity<Product>> updateProduct(@RequestBody Product product){
        return productService.update(product);
    }

}
