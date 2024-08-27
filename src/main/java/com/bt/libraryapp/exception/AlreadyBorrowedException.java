package com.bt.libraryapp.exception;

public class AlreadyBorrowedException extends RuntimeException {
  public AlreadyBorrowedException(String message) {
    super(message);
  }
}
