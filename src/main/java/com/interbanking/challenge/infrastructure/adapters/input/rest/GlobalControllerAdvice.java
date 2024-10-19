package com.interbanking.challenge.infrastructure.adapters.input.rest;

import com.interbanking.challenge.domain.exception.EnterpriseNotFoundException;
import com.interbanking.challenge.infrastructure.adapters.input.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.interbanking.challenge.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(EnterpriseNotFoundException.class)
  public ErrorResponse handleEnterpriseNotFoundException() {
    return ErrorResponse.builder()
        .code(ENTERPRISE_NOT_FOUND.getCode())
        .message(ENTERPRISE_NOT_FOUND.getMessage())
        .timestamp(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();

      List<String> list = new ArrayList<>();
      for (FieldError fieldError : result.getFieldErrors()) {
          String defaultMessage = fieldError.getDefaultMessage();
          list.add(defaultMessage);
      }
      return  ErrorResponse.builder()
            .code(INVALID_ENTERPRISE.getCode())
            .message(INVALID_ENTERPRISE.getMessage())
            .details(list)
            .timestamp(LocalDateTime.now())
            .build();
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ErrorResponse handleGenericError(Exception exception) {
    return ErrorResponse.builder()
        .code(GENERIC_ERROR.getCode())
        .message(GENERIC_ERROR.getMessage())
        .details(Collections.singletonList(exception.getMessage()))
        .timestamp(LocalDateTime.now())
        .build();
  }

}
