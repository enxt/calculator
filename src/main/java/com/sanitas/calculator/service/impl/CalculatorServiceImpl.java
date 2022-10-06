package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.service.operation.OperationContext;
import io.corp.calculator.TracerImpl;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * {@link CalculatorService} implementation
 */
@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

  private final TracerImpl tracer;
  private final OperationContext operationContext;

  /**
   * @see CalculatorService#calculate(OperationRequest)
   */
  @Override
  public BigDecimal calculate(OperationRequest operationRequest) {
    final var result = operationContext.execute(operationRequest);
    tracer.trace(result);
    return result;
  }
}
