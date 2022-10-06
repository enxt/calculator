package com.sanitas.calculator.service;

import com.sanitas.calculator.dto.OperationRequest;
import java.math.BigDecimal;

/**
 * Calculator service
 */
public interface CalculatorService {

  /**
   * Performs the calculation for the data provided
   *
   * @param operationRequest {@link OperationRequest} data
   * @return BigDecimal with result number object
   */
  BigDecimal calculate(OperationRequest operationRequest);
}
