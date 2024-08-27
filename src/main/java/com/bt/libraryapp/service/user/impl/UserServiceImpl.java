package com.bt.libraryapp.service.user.impl;

import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.user.UserResponse;
import com.bt.libraryapp.entity.User;
import com.bt.libraryapp.entity.UserRole;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.mapper.user.UserMapper;
import com.bt.libraryapp.repository.user.UserRepository;
import com.bt.libraryapp.service.user.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserResponse save(CreateUserRequest createUserRequest) {
    User user = userMapper.createUserRequestToUser(createUserRequest);
    user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
    return userMapper.userToUserResponse(userRepository.save(user));
  }

  @Override
  public UserResponse findById(long id) {
    return userMapper.userToUserResponse(getUserEntityById(id));
  }

  private User getUserEntityById(long id) {
    return userRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("User with id " + id + " could not be found!"));
  }

  @Override
  public List<UserResponse> findAll() {
    List<User> users = userRepository.findAll();
    return userMapper.usersToUserResponses(users);
  }

  @Override
  public List<UserResponse> findAllByRole(UserRole role) {
    List<User> users = userRepository.findAllByRole(role);
    return userMapper.usersToUserResponses(users);
  }

  @Override
  public void deleteById(long id) {
    if (!userRepository.existsById(id)) {
      throw new NotFoundException("User with id " + id + " could not be found!");
    }
    userRepository.deleteById(id);
  }
}
