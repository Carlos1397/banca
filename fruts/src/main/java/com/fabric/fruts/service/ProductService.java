package com.fabric.fruts.service;

import com.fabric.fruts.entity.Product;
import com.fabric.fruts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Flux<Product> getAllProducts(){
        return productRepository.findAll().map(p->{
            Product newproduct = new Product();
            newproduct.setId(p.getId());
            newproduct.setTitle(p.getTitle());
            return newproduct;
        });
    }

    public Mono<Product> save(Product product){
       com.fabric.fruts.entity.Product p = new com.fabric.fruts.entity.Product();
       p.setId(new Random().nextInt());
       p.setTitle(product.getTitle());
       return productRepository.save(p).delayElement(Duration.ofMillis(3000)).map(pr ->{
           Product newproduc = new Product();
          newproduc.setId(pr.getId());
          newproduc.setTitle(pr.getTitle());
          return newproduc;
       });
    }

    public Mono<Void> deleteProduct(int id) {
        return productRepository.deleteById(id);
    }
    public Mono<ResponseEntity<Product>> update(Product product) {
        System.out.println(product.getId());
        System.out.println(product.getTitle());
        return productRepository.findById(product.getId())
                .flatMap(p -> {
                    System.out.println(p.getId());
                    System.out.println(p.getTitle());
                    p.setTitle(product.getTitle());
                    return productRepository.save(p);
                })
                .map(updatedItem -> {
                    Product product1 = new Product();
                    product1.setId(updatedItem.getId());
                    product1.setTitle(updatedItem.getTitle());
                    return new ResponseEntity<>(product1, HttpStatus.OK);
                })
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
