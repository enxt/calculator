package com.sanitas.calculator.service.operation;

import com.sanitas.calculator.dto.OperationEnum;
import java.math.BigDecimal;

/**
 * Operational interface, to realize the calc
 */
public interface Operation {

  /**
   * Gets the type of operation that can execute
   *
   * @return {@link OperationEnum} enum element
   */
  OperationEnum getOperation();

  /**
   * Makes the calc/s
   *
   * @param number1 BigDecimal first operand
   * @param number2 BigDecimal second operand
   * @return BigDecimal result for the calc
   */
  BigDecimal calculate(BigDecimal number1, BigDecimal number2);
}
