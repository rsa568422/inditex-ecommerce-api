package org.inditex.ecommerce.api.controllers;

import org.iditex.ecommerce.model.entities.Product;
import org.inditex.ecommerce.api.data.ProductData;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    @LocalServerPort
    private int port;

    @Test
    @Order(1)
    void testFindVisiblesOrderBySequence() {
        ResponseEntity<Product[]> response = client.getForEntity(getFullUri("/api/products"), Product[].class);
        Set<Product> products = Set.of(Objects.requireNonNull(response.getBody()));

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                () -> assertEquals(ProductData.findVisiblesOrderBySequence(), products)
        );
    }

    private String getFullUri(String partialUri) {
        return String.format("http://localhost:%d%s", port, partialUri);
    }
}