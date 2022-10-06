package com.sanitas.calculator.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sanitas.calculator.dto.OperationEnum;
import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.dto.api.OperationRequestDto;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

  @Mock
  ModelMapper modelMapper;

  @Mock
  CalculatorService calculatorService;

  CalculatorController calculatorController;

  @BeforeEach
  void setUp() {
    calculatorController = new CalculatorController(calculatorService, modelMapper);
  }

  @Test
  void calculate() {

    var operationRequestDto = new OperationRequestDto();
    operationRequestDto.setOperation(OperationRequestDto.OperationEnum.ADD);
    operationRequestDto.setNumber1(BigDecimal.valueOf(232.2));
    operationRequestDto.setNumber2(BigDecimal.valueOf(232.22));

    var operationRequest = new OperationRequest();
    operationRequest.setOperation(OperationEnum.ADD);
    operationRequest.setNumber1(BigDecimal.valueOf(232.2));
    operationRequest.setNumber2(BigDecimal.valueOf(232.22));

    var expected = BigDecimal.ZERO;

    when(modelMapper.map(any(OperationRequestDto.class), any())).thenReturn(operationRequest);
    when(calculatorService.calculate(any())).thenReturn(expected);

    var result = calculatorController.calculate(operationRequestDto);

    assertNotNull(result);
    assertNotNull(result.getBody());
    assertEquals(expected, result.getBody());
  }
}
