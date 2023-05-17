package org.inditex.ecommerce.api.persistence.repositories;

import org.inditex.ecommerce.api.data.ProductData;
import org.inditex.ecommerce.api.persistence.entities.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductH2RepositoryIntegrationTest {

    @Autowired
    private ProductH2Repository repository;

    @Test
    void testFindAll() {
        List<ProductDto> products = repository.findAll();

        assertAll(
                () -> assertEquals(5, products.size()),
                () -> assertTrue(products.stream().map(ProductDto::getId).collect(Collectors.toSet()).containsAll(Set.of(1L, 2L, 3L, 4L, 5L))),
                () -> {
                    ProductDto product = products.stream().filter(p -> p.getId().equals(1L)).findFirst().orElse(null);
                    assertEquals(ProductData.DTO.get(1L), product);
                },
                () -> {
                    ProductDto product = products.stream().filter(p -> p.getId().equals(2L)).findFirst().orElse(null);
                    assertEquals(ProductData.DTO.get(2L), product);
                },
                () -> {
                    ProductDto product = products.stream().filter(p -> p.getId().equals(3L)).findFirst().orElse(null);
                    assertEquals(ProductData.DTO.get(3L), product);
                },
                () -> {
                    ProductDto product = products.stream().filter(p -> p.getId().equals(4L)).findFirst().orElse(null);
                    assertEquals(ProductData.DTO.get(4L), product);
                },
                () -> {
                    ProductDto product = products.stream().filter(p -> p.getId().equals(5L)).findFirst().orElse(null);
                    assertEquals(ProductData.DTO.get(5L), product);
                }
        );
    }

}