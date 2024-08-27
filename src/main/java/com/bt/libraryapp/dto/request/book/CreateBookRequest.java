package com.bt.libraryapp.dto.request.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {
  @NotBlank private String title;
  @NotBlank private String author;
  @NotBlank private String genre;
  @NotBlank private String description;
  @NotBlank private String publisher;
  @NotBlank private String publicationYear;
  @NotNull private int totalCopies;
}
