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
}