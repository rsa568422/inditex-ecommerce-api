package org.inditex.ecommerce.api.persistence.entities;

import org.inditex.ecommerce.api.data.StockData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StockDtoTest {

    @ParameterizedTest(name = "testToModel for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "22", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testToModel(String param) {
        Long id = Long.valueOf(param);

        assertEquals(StockData.STOCKS.get(id), StockData.DTO.get(id).toModel());
    }

    @ParameterizedTest(name = "testConstructorAndSetters for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "22", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testConstructorAndSetters(String param) {
        Long id = Long.valueOf(param);
        StockDto expected = StockData.DTO.get(id);

        StockDto dtoA = new StockDto(expected.getSizeId(), expected.getQuantity());
        StockDto dtoB = new StockDto();
        dtoB.setSizeId(expected.getSizeId());
        dtoB.setQuantity(expected.getQuantity());

        assertAll(
                () -> assertEquals(expected, dtoA),
                () -> assertEquals(expected, dtoB),
                () -> assertEquals(dtoA, dtoB),
                () -> assertEquals(dtoB, dtoA)
        );
    }

    @ParameterizedTest(name = "testToStringAndHashCode for id {argumentsWithNames}")
    @ValueSource(strings = {"11", "12", "13", "22", "31", "32", "33", "41", "42", "43", "44", "51", "52", "53", "54"})
    void testToStringAndHashCode(String param) {
        Long id = Long.valueOf(param);
        StockDto expected = StockData.DTO.get(id);

        StockDto dtoA = new StockDto(expected.getSizeId(), expected.getQuantity());

        assertAll(
                () -> assertEquals(expected.toString(), dtoA.toString()),
                () -> assertEquals(expected.hashCode(), dtoA.hashCode())
        );
    }

}