package com.bt.libraryapp.dto.response.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
  private long id;
  private String title;
  private String author;
  private String genre;
  private String description;
  private String publisher;
  private String publicationYear;
  private int totalCopies;
}
