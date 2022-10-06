package com.sanitas.calculator.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Model mapper configuration
 */
@Configuration
public class ModelMapperConfiguration {

  /**
   * Create model mapper bean
   *
   * @return {@link ModelMapper} bean
   */
  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
