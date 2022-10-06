package com.sanitas.calculator.controllers;

import com.sanitas.api.CalculatorApi;
import com.sanitas.dto.api.OperationRequestDto;
import java.math.BigDecimal;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController implements CalculatorApi {
  @Override
  public ResponseEntity<BigDecimal> calculate(
      @Valid final OperationRequestDto operationRequestDto) {
    return new ResponseEntity<>(BigDecimal.TEN, HttpStatus.CREATED);
  }
}
