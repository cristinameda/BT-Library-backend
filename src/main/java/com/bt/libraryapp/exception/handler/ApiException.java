package com.bt.libraryapp.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException {

  private HttpStatus status;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime timestamp;

  private String message;

  private ApiException() {
    this.timestamp = LocalDateTime.now();
  }

  public ApiException(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiException(HttpStatus status, String message) {
    this();
    this.status = status;
    this.message = message;
  }
}
