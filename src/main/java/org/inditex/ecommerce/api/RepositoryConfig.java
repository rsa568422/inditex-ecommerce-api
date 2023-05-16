package org.inditex.ecommerce.api;

import org.iditex.ecommerce.model.repositories.ProductRepository;
import org.inditex.ecommerce.persistence.csv.repositories.ProductCsvRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {

    @Bean
    @Primary
    public ProductRepository getCsvRepository() {
        return new ProductCsvRepository();
    }

}
