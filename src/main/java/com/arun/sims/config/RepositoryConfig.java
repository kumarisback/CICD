package com.arun.sims.config;

import com.arun.sims.repository.IncidentElasticsearchRepository;
import com.arun.sims.repository.IncidentJpaRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.arun.sims.repository", // Package for JPA repositories
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = IncidentJpaRepository.class)
)
@EnableElasticsearchRepositories(
        basePackages = "com.arun.sims.repository", // Package for Elasticsearch repositories
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = IncidentElasticsearchRepository.class)
)
public class RepositoryConfig {
}