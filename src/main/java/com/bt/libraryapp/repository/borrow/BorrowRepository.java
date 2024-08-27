package com.bt.libraryapp.repository.borrow;

import com.bt.libraryapp.entity.Borrow;
import com.bt.libraryapp.entity.BorrowStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

  List<Borrow> findAllByUserId(long userId);

  List<Borrow> findAllByStatus(BorrowStatus status);

  List<Borrow> findAllByBookId(long bookId);

  List<Borrow> findAllByUserIdAndBookId(long userId, long bookId);

  List<Borrow> findAllByUserIdAndStatus(long userId, BorrowStatus status);
}
