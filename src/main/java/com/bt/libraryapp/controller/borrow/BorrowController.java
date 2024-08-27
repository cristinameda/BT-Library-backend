package com.bt.libraryapp.controller.borrow;

import com.bt.libraryapp.dto.request.borrow.BorrowRequest;
import com.bt.libraryapp.dto.response.borrow.BorrowResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface BorrowController {
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<BorrowResponse> save(@Valid @RequestBody BorrowRequest borrowRequest);

  @PutMapping(path = "/return/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<BorrowResponse> returnBorrow(@PathVariable long id);

  @PutMapping(path = "/pay-fee/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<BorrowResponse> payFee(@PathVariable long id);

  @GetMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<BorrowResponse> findById(@PathVariable long id);

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BorrowResponse>> findAll();

  @GetMapping(path = "/user/id/{userId}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BorrowResponse>> findAllByUserId(@PathVariable long userId);

  @GetMapping(path = "/status/{status}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BorrowResponse>> findAllByStatus(@PathVariable String status);

  @GetMapping(path = "/user/id/{userId}/status/{status}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BorrowResponse>> findAllByUserIdAndStatus(
      @PathVariable long userId, @PathVariable String status);

  @GetMapping(path = "/book/id/{bookId}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<BorrowResponse>> findAllByBookId(@PathVariable long bookId);

  @DeleteMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<Void> deleteById(@PathVariable long id);
}
