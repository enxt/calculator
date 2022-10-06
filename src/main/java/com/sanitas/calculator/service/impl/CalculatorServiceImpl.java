package com.sanitas.calculator.service.impl;

import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * {@link CalculatorService} implementation
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class CalculatorServiceImpl implements CalculatorService {

  /**
   * @see CalculatorService#calculate(OperationRequest)
   */
  @Override
  public BigDecimal calculate(OperationRequest operationRequest) {
    log.debug("CalculatorServiceImpl - calculate");
    return BigDecimal.TEN;
  }
}
