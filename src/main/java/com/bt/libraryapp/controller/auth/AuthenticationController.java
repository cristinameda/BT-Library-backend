package com.bt.libraryapp.controller.auth;

import com.bt.libraryapp.dto.request.auth.LoginRequest;
import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.auth.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationController {
  @PostMapping(path = "/login")
  ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest);

  @PostMapping(path = "/register")
  ResponseEntity<AuthResponse> register(@RequestBody CreateUserRequest createUserRequest);
}
