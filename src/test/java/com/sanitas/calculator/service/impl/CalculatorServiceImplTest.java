package com.sanitas.calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.sanitas.calculator.dto.OperationEnum;
import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.calculator.service.operation.AdditionOperationImpl;
import com.sanitas.calculator.service.operation.Operation;
import com.sanitas.calculator.service.operation.OperationContext;
import io.corp.calculator.TracerImpl;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(classes = {CalculatorServiceImpl.class, TracerImpl.class,
    OperationContext.class,
    AdditionOperationImpl.class})
class CalculatorServiceImplTest {

  @Autowired
  CalculatorService calculatorService;

  @Test
  void calculate() {
    var operationRequest = new OperationRequest();
    operationRequest.setOperation(OperationEnum.ADD);
    operationRequest.setNumber1(BigDecimal.valueOf(11123.3));
    operationRequest.setNumber2(BigDecimal.valueOf(2342.2));

    final var result = calculatorService.calculate(operationRequest);

    assertEquals(operationRequest.getNumber1().add(operationRequest.getNumber2()), result);
  }

  @Test
  void calculate_fail_operation_null() {
    var operationRequest = new OperationRequest();
    operationRequest.setOperation(null);
    operationRequest.setNumber1(BigDecimal.valueOf(11123.3));
    operationRequest.setNumber2(BigDecimal.valueOf(23.3));

    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.calculatorService.calculate(operationRequest));

    var expectedMessage = "Invalid operation type: null, number1: 11123.3, number2: 23.3";

    assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  void calculate_fail_number_null() {
    var operationRequest = new OperationRequest();
    operationRequest.setOperation(OperationEnum.ADD);
    operationRequest.setNumber1(BigDecimal.valueOf(11123.3));
    operationRequest.setNumber2(null);

    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> this.calculatorService.calculate(operationRequest));

    var expectedMessage = "Invalid operation type: ADD, number1: 11123.3, number2: null";

    assertEquals(expectedMessage, exception.getMessage());
  }
}
