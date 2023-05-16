package org.inditex.ecommerce.api.services;

import org.iditex.ecommerce.model.entities.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> findVisiblesOrderBySequence();

}
