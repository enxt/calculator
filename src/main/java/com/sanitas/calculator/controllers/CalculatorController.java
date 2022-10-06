package com.sanitas.calculator.controllers;

import com.sanitas.api.CalculatorApi;
import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.dto.api.OperationRequestDto;
import java.math.BigDecimal;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@Validated
public class CalculatorController implements CalculatorApi {

  private final CalculatorService calculatorService;
  private final ModelMapper modelMapper;

  @Override
  public ResponseEntity<BigDecimal> calculate(
      @Valid final OperationRequestDto operationRequestDto) {

    log.debug("CalculatorController - calculate: Start");
    final var result = calculatorService.calculate(
        modelMapper.map(operationRequestDto, OperationRequest.class)
    );
    log.debug("CalculatorController - calculate: End");
    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }
}
