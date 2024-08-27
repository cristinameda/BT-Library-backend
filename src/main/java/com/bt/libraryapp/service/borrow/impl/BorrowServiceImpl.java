package com.bt.libraryapp.service.borrow.impl;

import com.bt.libraryapp.dto.response.borrow.BorrowResponse;
import com.bt.libraryapp.entity.Book;
import com.bt.libraryapp.entity.Borrow;
import com.bt.libraryapp.entity.BorrowStatus;
import com.bt.libraryapp.entity.User;
import com.bt.libraryapp.exception.AlreadyBorrowedException;
import com.bt.libraryapp.exception.BorrowStatusException;
import com.bt.libraryapp.exception.FeeAlreadyZeroOrPayed;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.mapper.borrow.BorrowMapper;
import com.bt.libraryapp.repository.book.BookRepository;
import com.bt.libraryapp.repository.borrow.BorrowRepository;
import com.bt.libraryapp.repository.user.UserRepository;
import com.bt.libraryapp.service.borrow.BorrowService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {
  private final UserRepository userRepository;
  private final BookRepository bookRepository;
  private final BorrowRepository borrowRepository;
  private final BorrowMapper borrowMapper;

  private static Borrow buildNewBorrow(User user, Book book) {
    return Borrow.builder()
        .user(user)
        .book(book)
        .borrowDate(LocalDate.now())
        .dueDate(LocalDate.now().plusDays(30))
        .returnDate(null)
        .status(BorrowStatus.BORROWED)
        .fee(0)
        .build();
  }

  @Override
  public BorrowResponse borrow(long userId, long bookId) {
    User user = getUser(userId);
    Book book = getBook(bookId);

    if (userAlreadyBorrowedBookAndNotYetReturned(userId, bookId)) {
      throw new AlreadyBorrowedException(
          "User with id "
              + userId
              + " already borrowed book with id "
              + bookId
              + " and didn't return it yet!");
    }

    Borrow borrow = borrowRepository.save(buildNewBorrow(user, book));
    updateCopiesStock(book, 1);
    return borrowMapper.borrowToBorrowResponse(borrow);
  }

  @Override
  public BorrowResponse returnBorrow(long borrowId) {
    Borrow borrow = getBorrowEntity(borrowId);

    if (hasAlreadyBeenReturned(borrow)) {
      throw new BorrowStatusException(
          "Borrow with id " + borrowId + " has already been returned! Status: RETURNED");
    }

    borrow.setStatus(BorrowStatus.RETURNED);
    borrow.setReturnDate(LocalDate.now());
    borrow.setFee(calculateFee(borrow));
    updateCopiesStock(borrow.getBook(), 1);
    return borrowMapper.borrowToBorrowResponse(borrowRepository.save(borrow));
  }

  @Override
  public BorrowResponse payFee(long borrowId) {
    Borrow borrow = getBorrowEntity(borrowId);

    if (!hasAlreadyBeenReturned(borrow)) {
      throw new BorrowStatusException(
          "Borrow with id " + borrowId + " has not been returned! Status: BORROWED");
    }

    if (borrow.getFee() == 0) {
      throw new FeeAlreadyZeroOrPayed("Borrow with id " + borrowId + " has no fee!");
    }

    borrow.setFee(0);
    return borrowMapper.borrowToBorrowResponse(borrowRepository.save(borrow));
  }

  @Override
  public BorrowResponse findById(long borrowId) {
    return borrowMapper.borrowToBorrowResponse(getBorrowEntity(borrowId));
  }

  @Override
  public List<BorrowResponse> findAll() {
    List<Borrow> borrows = borrowRepository.findAll();
    return borrowMapper.borrowsToBorrowResponses(borrows);
  }

  @Override
  public List<BorrowResponse> findAllByUserId(long userId) {
    List<Borrow> borrows = borrowRepository.findAllByUserId(userId);
    return borrowMapper.borrowsToBorrowResponses(borrows);
  }

  @Override
  public List<BorrowResponse> findAllByStatus(BorrowStatus status) {
    List<Borrow> borrows = borrowRepository.findAllByStatus(status);
    return borrowMapper.borrowsToBorrowResponses(borrows);
  }

  @Override
  public List<BorrowResponse> findAllByUserIdAndStatus(long userId, BorrowStatus status) {
    List<Borrow> borrows = borrowRepository.findAllByUserIdAndStatus(userId, status);
    return borrowMapper.borrowsToBorrowResponses(borrows);
  }

  @Override
  public List<BorrowResponse> findAllByBookId(long bookId) {
    List<Borrow> borrows = borrowRepository.findAllByBookId(bookId);
    return borrowMapper.borrowsToBorrowResponses(borrows);
  }

  @Override
  public void deleteById(long borrowId) {
    Borrow borrow = getBorrowEntity(borrowId);
    borrowRepository.deleteById(borrowId);
    updateCopiesStock(borrow.getBook(), -1);
  }

  private User getUser(long userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(
            () -> new NotFoundException("User with id " + userId + " could not be found!"));
  }

  private Book getBook(long bookId) {
    return bookRepository
        .findById(bookId)
        .orElseThrow(
            () -> new NotFoundException("Book with id " + bookId + " could not be found!"));
  }

  private boolean userAlreadyBorrowedBookAndNotYetReturned(long userId, long bookId) {
    List<Borrow> borrows = borrowRepository.findAllByUserIdAndBookId(userId, bookId);
    List<Borrow> activeBorrows =
        borrows.stream()
            .filter(borrow -> borrow.getStatus().equals(BorrowStatus.BORROWED))
            .toList();
    return !activeBorrows.isEmpty();
  }

  private void updateCopiesStock(Book book, int quantity) {
    book.setTotalCopies(book.getTotalCopies() + quantity);
    bookRepository.save(book);
  }

  private Borrow getBorrowEntity(long id) {
    return borrowRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Borrow with id " + id + " could not be found!"));
  }

  private boolean hasAlreadyBeenReturned(Borrow borrow) {
    return borrow.getStatus().equals(BorrowStatus.RETURNED);
  }

  private double calculateFee(Borrow borrow) {
    long daysLate = ChronoUnit.DAYS.between(borrow.getDueDate(), borrow.getReturnDate());
    return (double) daysLate * 0.5;
  }
}
