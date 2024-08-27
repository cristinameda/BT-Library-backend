package com.bt.libraryapp.dto.response.borrow;

import com.bt.libraryapp.dto.response.book.BookResponse;
import com.bt.libraryapp.dto.response.user.UserResponse;
import com.bt.libraryapp.entity.BorrowStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowResponse {
  private long id;
  private UserResponse user;
  private BookResponse book;
  private LocalDate borrowDate;
  private LocalDate dueDate;
  private LocalDate returnDate;
  private BorrowStatus status;
  private double fee;
}
