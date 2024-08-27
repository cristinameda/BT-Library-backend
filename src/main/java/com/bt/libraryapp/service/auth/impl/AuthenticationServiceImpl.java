package com.bt.libraryapp.service.auth.impl;

import com.bt.libraryapp.dto.request.auth.LoginRequest;
import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.auth.AuthResponse;
import com.bt.libraryapp.entity.User;
import com.bt.libraryapp.entity.UserRole;
import com.bt.libraryapp.exception.NotFoundException;
import com.bt.libraryapp.exception.UnsuccessfulAuthenticationException;
import com.bt.libraryapp.mapper.user.UserMapper;
import com.bt.libraryapp.repository.user.UserRepository;
import com.bt.libraryapp.security.config.JwtService;
import com.bt.libraryapp.service.auth.AuthenticationService;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  private static void logUserAuthentication(String username) {
    LOGGER.info("User with username {} has logged in", username);
  }

  @Override
  public AuthResponse authenticate(LoginRequest loginRequest) {
    String username = loginRequest.getUsername();
    String password = loginRequest.getPassword();
    Authentication auth;
    String jwtToken;

    try {
      auth =
          authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(username, password));
      Object user = auth.getPrincipal();
      logUserAuthentication(username);

      if (user instanceof User libraryUser) {
        jwtToken = jwtService.generateToken(getMapId(libraryUser.getId()), libraryUser);
        return new AuthResponse(userMapper.userToUserResponse(libraryUser), jwtToken);
      }

      throw new NotFoundException(
          "User with username " + loginRequest.getUsername() + " could not be found!");

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      throw new UnsuccessfulAuthenticationException(e.getMessage());
    }
  }

  @Override
  public AuthResponse register(CreateUserRequest createUserRequest) {
    User newUser = userMapper.createUserRequestToUser(createUserRequest);
    newUser.setRole(UserRole.CUSTOMER);
    newUser.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
    newUser = userRepository.save(newUser);
    LOGGER.info("User with id {} was created", newUser.getId());
    String jwtToken = jwtService.generateToken(getMapId(newUser.getId()), newUser);
    return new AuthResponse(userMapper.userToUserResponse(newUser), jwtToken);
  }

  private Map<String, Object> getMapId(long id) {
    Map<String, Object> mapId = new HashMap<>();
    mapId.put("id", id);
    return mapId;
  }
}
