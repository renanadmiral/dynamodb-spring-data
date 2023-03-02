package com.example.renan.dynamo.controller;

import com.example.renan.dynamo.entities.Product;
import com.example.renan.dynamo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product post(@RequestBody final Map<String, String> requestBody) {
        return productRepository.save(
                Product.builder()
                        .name(requestBody.get("name"))
                        .stockAmmount(Integer.valueOf(requestBody.get("stockAmmount")))
                        .build()
        );
    }

    @GetMapping
    public Page<Product> get(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
