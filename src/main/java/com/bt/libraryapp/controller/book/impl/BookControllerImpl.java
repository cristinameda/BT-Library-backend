package com.bt.libraryapp.controller.book.impl;

import com.bt.libraryapp.controller.book.BookController;
import com.bt.libraryapp.dto.request.book.CreateBookRequest;
import com.bt.libraryapp.dto.response.book.BookResponse;
import com.bt.libraryapp.service.book.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookControllerImpl implements BookController {

  private final BookService bookService;

  @Override
  public ResponseEntity<BookResponse> save(CreateBookRequest createBookRequest) {
    return new ResponseEntity<>(bookService.save(createBookRequest), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<BookResponse> findById(long id) {
    return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BookResponse>> findAll() {
    return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteById(long id) {
    bookService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
