package com.bt.libraryapp.repository.book;

import com.bt.libraryapp.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findAllByTitleAndAuthor(String title, String author);
}
