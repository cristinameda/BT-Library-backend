package com.bt.libraryapp.service.book;

import com.bt.libraryapp.dto.request.book.CreateBookRequest;
import com.bt.libraryapp.dto.response.book.BookResponse;
import java.util.List;

public interface BookService {
  BookResponse save(CreateBookRequest createBookRequest);

  BookResponse findById(long id);

  List<BookResponse> findAll();

  void deleteById(long id);
}
