package com.bt.libraryapp.exception;

public class FeeAlreadyZeroOrPayed extends RuntimeException {
  public FeeAlreadyZeroOrPayed(String message) {
    super(message);
  }
}
