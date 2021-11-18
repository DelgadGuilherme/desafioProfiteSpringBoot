package com.example.desafioprofitback.model.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFound extends RuntimeException{
    public  ProductNotFound() {
        super("Não foi possivel carregar os produtos!");
    }
}
