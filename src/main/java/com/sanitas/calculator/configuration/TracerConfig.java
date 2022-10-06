package com.sanitas.calculator.configuration;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Tracer API configuration
 */
@Configuration
public class TracerConfig {

  /**
   * Create Tracer API bean
   *
   * @return {@link TracerImpl} bean
   */
  @Bean
  public TracerImpl getTracer() {
    return new TracerImpl();
  }
}
