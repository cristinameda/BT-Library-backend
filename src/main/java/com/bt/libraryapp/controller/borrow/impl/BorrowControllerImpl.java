package com.bt.libraryapp.controller.borrow.impl;

import com.bt.libraryapp.controller.borrow.BorrowController;
import com.bt.libraryapp.dto.request.borrow.BorrowRequest;
import com.bt.libraryapp.dto.response.borrow.BorrowResponse;
import com.bt.libraryapp.entity.BorrowStatus;
import com.bt.libraryapp.service.borrow.BorrowService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/borrows")
@AllArgsConstructor
public class BorrowControllerImpl implements BorrowController {
  private final BorrowService borrowService;

  @Override
  public ResponseEntity<BorrowResponse> save(BorrowRequest borrowRequest) {
    return new ResponseEntity<>(
        borrowService.borrow(borrowRequest.getUserId(), borrowRequest.getBookId()), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<BorrowResponse> returnBorrow(long id) {
    return new ResponseEntity<>(borrowService.returnBorrow(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<BorrowResponse> payFee(long id) {
    return new ResponseEntity<>(borrowService.payFee(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<BorrowResponse> findById(long id) {
    return new ResponseEntity<>(borrowService.findById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BorrowResponse>> findAll() {
    return new ResponseEntity<>(borrowService.findAll(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BorrowResponse>> findAllByUserId(long userId) {
    return new ResponseEntity<>(borrowService.findAllByUserId(userId), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BorrowResponse>> findAllByStatus(String status) {
    return new ResponseEntity<>(
        borrowService.findAllByStatus(BorrowStatus.valueOf(status)), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BorrowResponse>> findAllByUserIdAndStatus(long userId, String status) {
    return new ResponseEntity<>(
        borrowService.findAllByUserIdAndStatus(userId, BorrowStatus.valueOf(status)),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<BorrowResponse>> findAllByBookId(long bookId) {
    return new ResponseEntity<>(borrowService.findAllByBookId(bookId), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteById(long id) {
    borrowService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
