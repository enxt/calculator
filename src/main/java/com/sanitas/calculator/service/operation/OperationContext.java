package com.sanitas.calculator.service.operation;

import com.sanitas.calculator.dto.OperationRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Operation strategy context
 */
@Component
@RequiredArgsConstructor
public class OperationContext {

  private final List<Operation> operationList;

  /**
   * Execute the matching operation through the list of operations available
   *
   * @param operationDto {@link OperationRequest} current operation
   * @return BigDecimal with the result
   */
  public BigDecimal execute(final OperationRequest operationDto) {
    if(Objects.isNull(operationDto.getOperation())) {
      throw new IllegalArgumentException(illegalExMessage(operationDto));
    }
    var operation = operationList.stream()
        .filter(op -> op.getOperation().equals(operationDto.getOperation())).findFirst();

    if (operation.isEmpty() || Objects.isNull(operationDto.getNumber1()) || Objects.isNull(operationDto.getNumber2())) {
      throw new IllegalArgumentException(illegalExMessage(operationDto));
    }

    return operation.get().calculate(operationDto.getNumber1(), operationDto.getNumber2());
  }

  /**
   * Create the message for IllegalArgumentException
   *
   * @param operationDto {@link OperationRequest} current in exception operation
   * @return String with illegal argument exception message
   */
  private String illegalExMessage(OperationRequest operationDto) {
    return String.format("Invalid operation type: %s, number1: %s, number2: %s",
        operationDto.getOperation(),
        operationDto.getNumber1(),
        operationDto.getNumber2());
  }
}
