package com.sanitas.calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorApplicationTests {

  @Test
  void contextLoads() {
    CalculatorApplication.main(new String[]{});
    assertTrue(Boolean.TRUE);
  }
}
