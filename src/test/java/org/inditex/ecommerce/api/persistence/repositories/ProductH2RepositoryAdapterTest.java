package org.inditex.ecommerce.api.persistence.repositories;

import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.entities.Size;
import org.iditex.ecommerce.model.entities.Stock;
import org.inditex.ecommerce.api.data.ProductData;
import org.inditex.ecommerce.api.data.SizeData;
import org.inditex.ecommerce.api.data.StockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductH2RepositoryAdapterTest {

    private ProductH2RepositoryAdapter adapter;

    @MockBean
    private ProductH2Repository repository;

    @BeforeEach
    void setUp() {
        adapter = new ProductH2RepositoryAdapter(repository);
    }

    @Test
    void testFindVisiblesOrderBySequence() {
        when(repository.findAll()).thenReturn(new ArrayList<>(ProductData.DTO.values()));

        Set<Product> visibleProducts = adapter.findVisiblesOrderBySequence();
        StringJoiner joiner = new StringJoiner(", ");
        visibleProducts.stream().map(Product::getId).map(Objects::toString).forEach(joiner::add);

        assertEquals("5, 1, 3", joiner.toString());
    }

    @ParameterizedTest(name = "testFindByProductId for id {argumentsWithNames}")
    @ValueSource(strings = {"1", "3", "5"})
    void testFindVisiblesOrderBySequenceElements(String param) {
        Long id = Long.valueOf(param);

        when(repository.findAll()).thenReturn(new ArrayList<>(ProductData.DTO.values()));

        Map<Long, Product> products = adapter.findVisiblesOrderBySequence()
                .stream()
                .collect(Collectors.groupingBy(Product::getId,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))
                ));

        assertAll(
                () -> assertEquals(ProductData.PRODUCTS.get(id), products.get(id)),
                () -> assertEquals(ProductData.PRODUCTS.get(id).getId(), products.get(id).getId()),
                () -> assertEquals(ProductData.PRODUCTS.get(id).getSequence(), products.get(id).getSequence()),
                () -> assertEquals(ProductData.PRODUCTS.get(id).isVisible(), products.get(id).isVisible()),
                () -> products.get(id).getSizes().forEach(size -> {
                    Size expectedSize = SizeData.SIZES.get(size.getId());
                    assertAll(
                            () -> assertEquals(expectedSize, size),
                            () -> assertEquals(expectedSize.getId(), size.getId()),
                            () -> assertEquals(expectedSize.getProductId(), size.getProductId()),
                            () -> assertEquals(expectedSize.isBackSoon(), size.isBackSoon()),
                            () -> assertEquals(expectedSize.isSpecial(), size.isSpecial()),
                            () -> assertEquals(expectedSize.getStock(), size.getStock()),
                            () -> size.getStock().ifPresent(stock -> {
                                Stock expectedStock = StockData.STOCKS.get(stock.getSizeId());
                                assertAll(
                                        () -> assertEquals(expectedStock, stock),
                                        () -> assertEquals(expectedStock.getSizeId(), stock.getSizeId()),
                                        () -> assertEquals(expectedStock.getQuantity(), stock.getQuantity())
                                );
                            })
                    );
                })
        );
    }

    @Test
    void testFindAll() {
        Set<Product> expected = ProductData.findAll();

        when(repository.findAll()).thenReturn(new ArrayList<>(ProductData.DTO.values()));

        Set<Product> products = adapter.findAll();

        assertEquals(expected, products);
    }
}