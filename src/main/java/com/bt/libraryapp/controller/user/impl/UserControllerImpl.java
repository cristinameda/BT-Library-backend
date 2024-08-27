package com.bt.libraryapp.controller.user.impl;

import com.bt.libraryapp.controller.user.UserController;
import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.user.UserResponse;
import com.bt.libraryapp.entity.UserRole;
import com.bt.libraryapp.service.user.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<UserResponse> save(CreateUserRequest createUserRequest) {
    return new ResponseEntity<>(userService.save(createUserRequest), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<UserResponse> findById(long id) {
    return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<UserResponse>> findAll() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<UserResponse>> findAllByRole(String role) {
    return new ResponseEntity<>(userService.findAllByRole(UserRole.valueOf(role)), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteById(long id) {
    userService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
