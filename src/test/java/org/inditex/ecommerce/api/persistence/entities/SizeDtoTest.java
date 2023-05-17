package org.inditex.ecommerce.api.persistence.entities;

import org.iditex.ecommerce.model.entities.Size;
import org.inditex.ecommerce.api.data.SizeData;
import org.inditex.ecommerce.api.data.StockData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SizeDtoTest {

    @MockBean
    private StockDto stock;

    @ParameterizedTest(name = "testToModel for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "21", "22", "23", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testToModel(String param) {
        Long id = Long.valueOf(param);
        SizeDto dto = SizeData.DTO.get(id);

        when(stock.toModel()).thenReturn(StockData.STOCKS.get(id));

        Size size = dto.toModel();

        assertEquals(SizeData.SIZES.get(id), size);
    }

    @ParameterizedTest(name = "testConstructorAndSetters for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "21", "22", "23", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testConstructorAndSetters(String param) {
        Long id = Long.valueOf(param);
        SizeDto expected = SizeData.DTO.get(id);

        SizeDto dtoA = new SizeDto(expected.getId(), expected.getProductId(), expected.isBackSoon(), expected.isSpecial(), expected.getStock());
        SizeDto dtoB = new SizeDto();
        dtoB.setId(expected.getId());
        dtoB.setProductId(expected.getProductId());
        dtoB.setBackSoon(expected.isBackSoon());
        dtoB.setSpecial(expected.isSpecial());
        dtoB.setStock(expected.getStock());

        assertAll(
                () -> assertEquals(expected, dtoA),
                () -> assertEquals(expected, dtoB),
                () -> assertEquals(dtoA, dtoB),
                () -> assertEquals(dtoB, dtoA)
        );
    }

    @ParameterizedTest(name = "testToStringAndHashCode for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "21", "22", "23", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testToStringAndHashCode(String param) {
        Long id = Long.valueOf(param);
        SizeDto expected = SizeData.DTO.get(id);

        SizeDto dtoA = new SizeDto(expected.getId(), expected.getProductId(), expected.isBackSoon(), expected.isSpecial(), expected.getStock());

        assertAll(
                () -> assertEquals(expected.toString(), dtoA.toString()),
                () -> assertEquals(expected.hashCode(), dtoA.hashCode())
        );
    }

}