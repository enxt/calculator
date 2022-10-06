package com.sanitas.calculator.dto;

import java.io.Serial;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Operation data to calculate
 */
@Getter
@Setter
public class OperationRequest {

  @Serial
  private static final long serialVersionUID = -2007613301674847918L;

  private OperationEnum operation;
  private BigDecimal number1;
  private BigDecimal number2;
}
