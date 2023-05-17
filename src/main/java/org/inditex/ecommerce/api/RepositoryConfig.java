package org.inditex.ecommerce.api;

import org.iditex.ecommerce.model.repositories.ProductRepository;
import org.inditex.ecommerce.api.persistence.repositories.ProductH2RepositoryAdapter;
import org.inditex.ecommerce.persistence.csv.repositories.ProductCsvRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {

    @Bean
    public ProductRepository getCsvRepository() {
        return new ProductCsvRepository();
    }

    @Bean
    @Primary
    public ProductRepository getH2Repository() {
        return new ProductH2RepositoryAdapter();
    }

}
