package com.bt.libraryapp.exception;

public class IllegalUserAccessException extends RuntimeException {
  public IllegalUserAccessException(String message) {
    super(message);
  }
}
