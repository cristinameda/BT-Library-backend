package com.bt.libraryapp.mapper.borrow;

import com.bt.libraryapp.dto.response.borrow.BorrowResponse;
import com.bt.libraryapp.entity.Borrow;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface BorrowMapper {
  BorrowResponse borrowToBorrowResponse(Borrow borrow);

  List<BorrowResponse> borrowsToBorrowResponses(List<Borrow> borrows);
}
