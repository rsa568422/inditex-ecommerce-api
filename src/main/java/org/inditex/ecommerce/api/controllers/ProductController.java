package org.inditex.ecommerce.api.controllers;

import org.iditex.ecommerce.model.entities.Product;
import org.inditex.ecommerce.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Product> findVisiblesOrderBySequence() {
        return service.findVisiblesOrderBySequence();
    }

}
