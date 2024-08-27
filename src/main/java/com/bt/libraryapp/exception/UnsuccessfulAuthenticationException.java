package com.bt.libraryapp.exception;

public class UnsuccessfulAuthenticationException extends RuntimeException {
  public UnsuccessfulAuthenticationException(String message) {
    super(message);
  }
}
