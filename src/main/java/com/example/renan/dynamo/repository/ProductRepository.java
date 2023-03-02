package com.example.renan.dynamo.repository;

import com.example.renan.dynamo.entities.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, String> {
    @EnableScan
    @EnableScanCount
    Page<Product> findAll(Pageable pageable);

}
