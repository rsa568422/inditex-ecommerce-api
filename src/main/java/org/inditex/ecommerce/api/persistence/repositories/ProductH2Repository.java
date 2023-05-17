package org.inditex.ecommerce.api.persistence.repositories;

import org.inditex.ecommerce.api.persistence.entities.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductH2Repository extends JpaRepository<ProductDto, Long> {

}
