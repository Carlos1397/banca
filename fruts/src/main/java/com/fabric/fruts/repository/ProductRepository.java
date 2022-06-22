package com.fabric.fruts.repository;

import com.fabric.fruts.entity.Product;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCassandraRepository<Product, Integer> {
}
