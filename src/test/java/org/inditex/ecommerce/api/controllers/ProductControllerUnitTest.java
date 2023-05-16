package org.inditex.ecommerce.api.controllers;

import org.inditex.ecommerce.api.data.ProductData;
import org.inditex.ecommerce.api.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Test
    void testFindVisiblesOrderBySequence() throws Exception {
        when(service.findVisiblesOrderBySequence()).thenReturn(ProductData.findVisiblesOrderBySequence());

        mvc.perform(get("/api/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id").value(5))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[2].id").value(3));

        verify(service, times(1)).findVisiblesOrderBySequence();
    }
}