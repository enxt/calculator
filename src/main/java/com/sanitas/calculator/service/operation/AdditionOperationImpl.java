package com.sanitas.calculator.service.operation;

import com.sanitas.calculator.dto.OperationEnum;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * {@link Operation} addition implementation
 */
@Component
public class AdditionOperationImpl implements Operation {

  /**
   * @see Operation#getOperation()
   */
  @Override
  public OperationEnum getOperation() {
    return OperationEnum.ADD;
  }

  /**
   * @see Operation#calculate(BigDecimal, BigDecimal)
   */
  @Override
  public BigDecimal calculate(@NotNull BigDecimal number1, @NotNull BigDecimal number2) {
    return number1.add(number2);
  }
}
