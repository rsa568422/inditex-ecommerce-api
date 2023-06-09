package org.inditex.ecommerce.api;

import org.iditex.ecommerce.model.entities.Product;
import org.iditex.ecommerce.model.repositories.ProductRepository;
import org.inditex.ecommerce.api.data.ProductData;
import org.inditex.ecommerce.api.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InditexEcommerceApiApplicationTests {

	@Autowired
	private ProductService service;

	@SpyBean
	private ProductRepository repository;

	@ParameterizedTest(name = "contextLoads for file {argumentsWithNames}")
	@ValueSource(strings = {"product", "size-1", "stock"})
	void contextLoads(String param) {
		assertTrue(Path.of(ROOT.concat(String.format("%s.csv", param))).toFile().canRead());
	}

	@Test
	void testService() {
		when(repository.findAll()).thenReturn(ProductData.findAll());

		Set<Product> products = service.findVisiblesOrderBySequence();
		StringJoiner joiner = new StringJoiner(", ");
		products.stream().map(Product::getId).map(Objects::toString).forEach(joiner::add);

		verify(repository, times(1)).findVisiblesOrderBySequence();
		verify(repository, times(1)).findAll();
		assertAll(
				() -> assertEquals("5, 1, 3", joiner.toString()),
				() -> assertEquals(ProductData.findVisiblesOrderBySequence(), products)
		);
	}

	private static final String RESOURCES = "\\src\\main\\resources\\";

	private static final String ROOT = FileSystems.getDefault()
			.getPath("")
			.normalize()
			.toAbsolutePath()
			.toString()
			.concat(RESOURCES);

}
