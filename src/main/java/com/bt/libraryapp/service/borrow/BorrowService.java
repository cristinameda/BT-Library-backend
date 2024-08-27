package com.bt.libraryapp.service.borrow;

import com.bt.libraryapp.dto.response.borrow.BorrowResponse;
import com.bt.libraryapp.entity.BorrowStatus;
import java.util.List;

public interface BorrowService {

  BorrowResponse borrow(long userId, long bookId);

  BorrowResponse returnBorrow(long borrowId);

  BorrowResponse payFee(long borrowId);

  BorrowResponse findById(long borrowId);

  List<BorrowResponse> findAll();

  List<BorrowResponse> findAllByUserId(long userId);

  List<BorrowResponse> findAllByStatus(BorrowStatus status);

  List<BorrowResponse> findAllByUserIdAndStatus(long userId, BorrowStatus status);

  List<BorrowResponse> findAllByBookId(long bookId);

  void deleteById(long borrowId);
}
