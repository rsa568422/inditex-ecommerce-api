package org.inditex.ecommerce.api.repositories;

import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.repositories.ProductRepository;
import org.inditex.ecommerce.persistence.csv.repositories.ProductCsvRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ProductRepositoryApi implements ProductRepository {

    private static final ProductCsvRepository REPOSITORY = new ProductCsvRepository();

    @Override
    public Set<Product> findAll() {
        return REPOSITORY.findAll();
    }

}
