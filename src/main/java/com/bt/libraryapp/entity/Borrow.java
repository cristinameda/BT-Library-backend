package com.bt.libraryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "borrows")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "borrow_id")
  private long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id", nullable = false)
  private Book book;

  @Column(name = "borrow_date", updatable = false, nullable = false)
  private LocalDate borrowDate;

  @Column(name = "due_date", updatable = false, nullable = false)
  private LocalDate dueDate;

  @Column(name = "return_date")
  private LocalDate returnDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private BorrowStatus status;

  @Column(name = "fee")
  private double fee;
}
