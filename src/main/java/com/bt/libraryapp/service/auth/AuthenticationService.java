package com.bt.libraryapp.service.auth;

import com.bt.libraryapp.dto.request.auth.LoginRequest;
import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.auth.AuthResponse;

public interface AuthenticationService {
  AuthResponse authenticate(LoginRequest loginRequest);

  AuthResponse register(CreateUserRequest createUserRequest);
}
