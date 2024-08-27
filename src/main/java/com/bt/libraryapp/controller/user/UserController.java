package com.bt.libraryapp.controller.user;

import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.user.UserResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  ResponseEntity<UserResponse> save(@Valid @RequestBody CreateUserRequest createUserRequest);

  @GetMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<UserResponse> findById(@PathVariable long id);

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<UserResponse>> findAll();

  @GetMapping(path = "/role/{role}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<UserResponse>> findAllByRole(@PathVariable String role);

  @DeleteMapping(path = "/id/{id}")
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<Void> deleteById(@PathVariable long id);
}
