package com.sanitas.calculator.service.operation;

import com.sanitas.calculator.dto.OperationEnum;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * {@link Operation} subtract implementation
 */
@Component
public class SubtractOperationImpl implements Operation {

  /**
   * @see Operation#getOperation()
   */
  @Override
  public OperationEnum getOperation() {
    return OperationEnum.SUB;
  }

  /**
   * @see Operation#calculate(BigDecimal, BigDecimal)
   */
  @Override
  public BigDecimal calculate(@NotNull BigDecimal number1, @NotNull BigDecimal number2) {
    return number1.subtract(number2);
  }
}
