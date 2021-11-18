package com.example.desafioprofitback.controller;

import com.example.desafioprofitback.model.entity.Product;
import com.example.desafioprofitback.model.repository.ProductNotFound;
import com.example.desafioprofitback.model.repository.ProductRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(JdbcTemplate jdbcTemplate) {
        productRepository = new ProductRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Product> searchAllProduct(){
        try {
            return productRepository.searchAllProduct();
        }
        catch (EmptyResultDataAccessException e) {
            throw new ProductNotFound();
        }
    }
}
