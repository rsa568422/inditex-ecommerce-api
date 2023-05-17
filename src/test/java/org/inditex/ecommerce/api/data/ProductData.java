package org.inditex.ecommerce.api.data;

import org.iditex.ecommerce.model.entities.Product;
import org.inditex.ecommerce.api.persistence.entities.ProductDto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductData {

    public static final Map<Long, Product> PRODUCTS = Stream.of(
            new Product(1L, 10L, SizeData.findByProductId(1L)),
            new Product(2L, 7L, SizeData.findByProductId(2L)),
            new Product(3L, 15L, SizeData.findByProductId(3L)),
            new Product(4L, 13L, SizeData.findByProductId(4L)),
            new Product(5L, 6L, SizeData.findByProductId(5L))
    ).collect(Collectors.groupingBy(Product::getId, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));

    public static final Map<Long, ProductDto> DTO = Stream.of(
            new ProductDto(1L, 10L, SizeData.findDtoByProductId(1L)),
            new ProductDto(2L, 7L, SizeData.findDtoByProductId(2L)),
            new ProductDto(3L, 15L, SizeData.findDtoByProductId(3L)),
            new ProductDto(4L, 13L, SizeData.findDtoByProductId(4L)),
            new ProductDto(5L, 6L, SizeData.findDtoByProductId(5L))
    ).collect(Collectors.groupingBy(ProductDto::getId, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));

    public static Set<Product> findAll() {
        return new HashSet<>(PRODUCTS.values());
    }

    public static Set<Product> findVisiblesOrderBySequence() {
        return Stream.of(
                ProductData.PRODUCTS.get(1L),
                ProductData.PRODUCTS.get(3L),
                ProductData.PRODUCTS.get(5L)
        ).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
