package org.inditex.ecommerce.api.persistence.repositories;

import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.repositories.ProductRepository;
import org.inditex.ecommerce.api.persistence.entities.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductH2RepositoryAdapter implements ProductRepository {

    @Autowired
    private ProductH2Repository repository;

    @Override
    public Set<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductDto::toModel)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
