package org.inditex.ecommerce.api.controllers;

import org.iditex.ecommerce.model.entities.Product;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Product[] products = Objects.requireNonNull(response.getBody());

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                () -> assertEquals(5L, products[0].getId()),
                () -> assertEquals(1L, products[1].getId()),
                () -> assertEquals(3L, products[2].getId())
        );
    }

    private String getFullUri(String partialUri) {
        return String.format("http://localhost:%d%s", port, partialUri);
    }
}