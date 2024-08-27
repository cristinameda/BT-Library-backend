package com.bt.libraryapp.mapper.book;

import com.bt.libraryapp.dto.request.book.CreateBookRequest;
import com.bt.libraryapp.dto.response.book.BookResponse;
import com.bt.libraryapp.entity.Book;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
  @Mapping(target = "id", ignore = true)
  Book createBookRequestToBook(CreateBookRequest createBookRequest);

  BookResponse bookToBookResponse(Book book);

  List<BookResponse> booksToBookResponses(List<Book> books);
}
