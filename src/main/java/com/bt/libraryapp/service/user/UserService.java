package com.bt.libraryapp.service.user;

import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.user.UserResponse;
import com.bt.libraryapp.entity.UserRole;
import java.util.List;

public interface UserService {
  UserResponse save(CreateUserRequest createUserRequest);

  UserResponse findById(long id);

  List<UserResponse> findAll();

  List<UserResponse> findAllByRole(UserRole role);

  void deleteById(long id);
}
