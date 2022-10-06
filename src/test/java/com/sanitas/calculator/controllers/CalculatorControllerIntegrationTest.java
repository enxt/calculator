package com.sanitas.calculator.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanitas.calculator.dto.OperationEnum;
import com.sanitas.calculator.dto.OperationRequest;
import com.sanitas.calculator.service.CalculatorService;
import com.sanitas.dto.api.OperationRequestDto;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = CalculatorController.class)
@AutoConfigureMockMvc(addFilters = false)
class CalculatorControllerIntegrationTest {

  private static final String URL = "/calculate";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  ModelMapper modelMapper;

  @MockBean
  CalculatorService calculatorService;

  @Test
  void calculate_created_result() throws Exception {

    var operationRequestDto = new OperationRequestDto();
        operationRequestDto.setOperation(OperationRequestDto.OperationEnum.ADD);
        operationRequestDto.setNumber1(BigDecimal.valueOf(232.2));
        operationRequestDto.setNumber2(BigDecimal.valueOf(232.22));

    var operationRequest = new OperationRequest();
        operationRequest.setOperation(OperationEnum.ADD);
        operationRequest.setNumber1(BigDecimal.valueOf(232.2));
        operationRequest.setNumber2(BigDecimal.valueOf(232.22));

    var result = BigDecimal.ZERO;

    when(modelMapper.map(any(OperationRequestDto.class), any()))
        .thenReturn(operationRequest);

    when(calculatorService.calculate(any())).thenReturn(result);

    mockMvc.perform(post(URL)
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(operationRequestDto))
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  void calculate_badrequest_exception() throws Exception {

    var result = BigDecimal.ZERO;
    when(calculatorService.calculate(any())).thenReturn(result);

    mockMvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(null))
            .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }
}
