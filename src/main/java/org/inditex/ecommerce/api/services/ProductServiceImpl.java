package org.inditex.ecommerce.api.services;

import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.repositories.ProductRepository;

import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Product> findVisiblesOrderBySequence() {
        return repository.findVisiblesOrderBySequence();
    }

}
