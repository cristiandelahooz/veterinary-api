package com.veterinarynux.veterinary_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
  // This class is responsible for configuring JPA settings.
  // It will include settings for Hibernate, entity scanning, and other
  // JPA-related configurations.
  // The class will be annotated with @Configuration to indicate that it is a
  // configuration class.
}
