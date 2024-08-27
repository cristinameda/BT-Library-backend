package com.bt.libraryapp.controller.auth.impl;

import com.bt.libraryapp.controller.auth.AuthenticationController;
import com.bt.libraryapp.dto.request.auth.LoginRequest;
import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.auth.AuthResponse;
import com.bt.libraryapp.service.auth.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {
  private final AuthenticationService authenticationService;

  @Override
  public ResponseEntity<AuthResponse> login(LoginRequest loginRequest) {
    return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
  }

  @Override
  public ResponseEntity<AuthResponse> register(CreateUserRequest createUserRequest) {
    return ResponseEntity.ok(authenticationService.register(createUserRequest));
  }
}
