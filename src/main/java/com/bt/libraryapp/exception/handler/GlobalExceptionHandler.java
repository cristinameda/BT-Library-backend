package com.bt.libraryapp.exception.handler;

import com.bt.libraryapp.exception.AlreadyBorrowedException;
import com.bt.libraryapp.exception.BookAlreadyExistsException;
import com.bt.libraryapp.exception.BorrowStatusException;
import com.bt.libraryapp.exception.FeeAlreadyZeroOrPayed;
import com.bt.libraryapp.exception.IllegalUserAccessException;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.exception.UnsuccessfulAuthenticationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handleNotFound(NotFoundException e) {
    return handleException(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BookAlreadyExistsException.class)
  public ResponseEntity<Object> handleBookAlreadyExits(BookAlreadyExistsException e) {
    return handleException(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AlreadyBorrowedException.class)
  public ResponseEntity<Object> handleAlreadyBorrowed(AlreadyBorrowedException e) {
    return handleException(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BorrowStatusException.class)
  public ResponseEntity<Object> handleBorrowStatus(BorrowStatusException e) {
    return handleException(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(FeeAlreadyZeroOrPayed.class)
  public ResponseEntity<Object> handleBorrowAlreadyReturned(FeeAlreadyZeroOrPayed e) {
    return handleException(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalUserAccessException.class)
  public ResponseEntity<Object> handleIllegalUserAccess(IllegalUserAccessException e) {
    return handleException(e, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(UnsuccessfulAuthenticationException.class)
  public ResponseEntity<Object> handleUnsuccessfulAuthentication(
      UnsuccessfulAuthenticationException e) {
    return handleException(e, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiException> handleMethodArgumentNotValid(
      MethodArgumentNotValidException e) {
    handleLogging(e, HttpStatus.BAD_REQUEST);
    StringBuilder errors = new StringBuilder();
    for (FieldError error : e.getBindingResult().getFieldErrors()) {
      errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(";  ");
    }
    for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
      errors
          .append(error.getObjectName())
          .append(": ")
          .append(error.getDefaultMessage())
          .append(";  ");
    }
    ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, errors.toString());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ApiException> handleConstraintViolation(ConstraintViolationException e) {
    handleLogging(e, HttpStatus.BAD_REQUEST);
    StringBuilder errors = new StringBuilder();
    for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
      errors
          .append(violation.getRootBeanClass().getName())
          .append(" ")
          .append(violation.getPropertyPath())
          .append(": ")
          .append(violation.getMessage());
    }
    ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, errors.toString());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
  }

  private ResponseEntity<Object> handleException(Exception e, HttpStatus status) {
    handleLogging(e, status);
    ApiException apiException = new ApiException(status, e.getMessage());
    return new ResponseEntity<>(apiException, status);
  }

  private void handleLogging(Throwable e, HttpStatus status) {
    if (status.is5xxServerError()) {
      LOGGER.error("A {} server error occurred", status, e);
    } else if (status.is4xxClientError()) {
      LOGGER.warn("A {} client error occurred", status, e);
    } else {
      LOGGER.debug("A {} error occurred", status, e);
    }
  }
}
