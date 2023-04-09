package com.jira.jiraApi;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jira.jiraApi.Repositories")
@EntityScan(basePackages = "com.jira.jiraApi.Models")
public class JpaConfig {
    // Configuración del EntityManager, etc.
}