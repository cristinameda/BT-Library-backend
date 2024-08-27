package com.bt.libraryapp.service.book.impl;

import com.bt.libraryapp.dto.request.book.CreateBookRequest;
import com.bt.libraryapp.dto.response.book.BookResponse;
import com.bt.libraryapp.entity.Book;
import com.bt.libraryapp.exception.BookAlreadyExistsException;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.mapper.book.BookMapper;
import com.bt.libraryapp.repository.book.BookRepository;
import com.bt.libraryapp.service.book.BookService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  @Override
  public BookResponse save(CreateBookRequest createBookRequest) {
    if (bookAlreadyExists(createBookRequest)) {
      throw new BookAlreadyExistsException(
          "Book with title "
              + createBookRequest.getTitle()
              + " from author "
              + createBookRequest.getAuthor()
              + " already exists in the library!");
    }
    Book book = bookMapper.createBookRequestToBook(createBookRequest);
    return bookMapper.bookToBookResponse(bookRepository.save(book));
  }

  @Override
  public BookResponse findById(long id) {
    return bookRepository
        .findById(id)
        .map(bookMapper::bookToBookResponse)
        .orElseThrow(() -> new NotFoundException("Book with id " + id + " could not be found!"));
  }

  @Override
  public List<BookResponse> findAll() {
    List<Book> books = bookRepository.findAll();
    return bookMapper.booksToBookResponses(books);
  }

  @Override
  public void deleteById(long id) {
    if (!bookRepository.existsById(id)) {
      throw new NotFoundException("Book with id " + id + " could not be found!");
    }
    bookRepository.deleteById(id);
  }

  private boolean bookAlreadyExists(CreateBookRequest createBookRequest) {
    List<Book> booksWithSameTitleAndAuthor =
        bookRepository.findAllByTitleAndAuthor(
            createBookRequest.getTitle(), createBookRequest.getAuthor());
    return !booksWithSameTitleAndAuthor.isEmpty();
  }
}
