package com.bt.libraryapp.controller.book;

import com.bt.libraryapp.dto.request.book.CreateBookRequest;
import com.bt.libraryapp.dto.response.book.BookResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BookController {
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<BookResponse> save(@Valid @RequestBody CreateBookRequest createBookRequest);

  @GetMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<BookResponse> findById(@PathVariable long id);

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BookResponse>> findAll();

  @DeleteMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<Void> deleteById(@PathVariable long id);
}
