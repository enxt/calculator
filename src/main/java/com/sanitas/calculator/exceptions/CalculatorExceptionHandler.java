package com.sanitas.calculator.exceptions;

import com.sanitas.dto.api.ErrorResponseDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Error handler
 */
@RestControllerAdvice
@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CalculatorExceptionHandler {

  /**
   * Handle ConstraintViolationException
   *
   * @param constraintViolationException {@link ConstraintViolationException} exception
   * @return {@link ErrorResponseDto} error dto
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = {
      ConstraintViolationException.class,
      HttpMessageNotReadableException.class})
  public ErrorResponseDto handleConstraintViolationException(
      ConstraintViolationException constraintViolationException) {
    return errorMessage(constraintViolationException);
  }

  /**
   * Handle IllegalArgumentException
   *
   * @param illegalArgumentException {@link IllegalArgumentException} exception
   * @return {@link ErrorResponseDto} error dto
   */
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ErrorResponseDto handleUnprocessableEntityExceptions(
      IllegalArgumentException illegalArgumentException) {
    return errorMessage(illegalArgumentException);
  }

  /**
   * Handle Exception and RuntimeException
   *
   * @param exception {@link Exception} exception
   * @return {@link ErrorResponseDto} error dto
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = {RuntimeException.class, Exception.class})
  public ErrorResponseDto handleGenericException(Exception exception) {
    return errorMessage(exception);
  }

  /**
   * Create and return error response
   *
   * @param exception Any exception
   * @return {@link ErrorResponseDto} dto
   */
  private ErrorResponseDto errorMessage(Exception exception) {
    var message = buildErrorMessage(exception);
    log.error(message, exception.getCause());
    var errorResponseDto = new ErrorResponseDto();
    errorResponseDto.setTimestamp(
        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    errorResponseDto.setMessage(message);
    return errorResponseDto;
  }

  /**
   * Build message to error dto
   *
   * @param exception Any exception
   * @return string with formatted message
   */
  private String buildErrorMessage(Exception exception) {
    return exception.getClass().getName() + " :: " + exception.getLocalizedMessage();
  }
}
