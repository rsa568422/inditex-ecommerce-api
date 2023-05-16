package org.inditex.ecommerce.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class InditexEcommerceApiApplicationTests {

	private static final String RESOURCES = "\\src\\main\\resources\\";


	private static final String ROOT = FileSystems.getDefault()
			.getPath("")
			.normalize()
			.toAbsolutePath()
			.toString()
			.concat(RESOURCES);

	@ParameterizedTest(name = "contextLoads for file {argumentsWithNames}")
	@ValueSource(strings = {"product", "size-1", "stock"})
	void contextLoads(String param) {
		assertTrue(Path.of(ROOT.concat(String.format("%s.csv", param))).toFile().canRead());
	}

}
