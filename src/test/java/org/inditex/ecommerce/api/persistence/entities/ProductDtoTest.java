package org.inditex.ecommerce.api.persistence.entities;

import org.iditex.ecommerce.model.entities.Product;
import org.inditex.ecommerce.api.data.ProductData;
import org.inditex.ecommerce.api.data.SizeData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductDtoTest {

    @MockBean
    private List<SizeDto> sizes;

    @ParameterizedTest(name = "testToModel for id {argumentsWithNames}")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void testToModel(String param) {
        Long id = Long.valueOf(param);
        ProductDto dto = ProductData.DTO.get(id);

        when(sizes.stream()).thenReturn(Stream.of(SizeData.findDtoByProductId(id).toArray(new SizeDto[]{})));

        Product product = dto.toModel();

        assertEquals(ProductData.PRODUCTS.get(id), product);
    }
}