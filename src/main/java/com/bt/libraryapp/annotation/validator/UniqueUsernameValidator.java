package com.bt.libraryapp.annotation.validator;

import com.bt.libraryapp.annotation.UniqueUsername;
import com.bt.libraryapp.repository.user.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
  private final UserRepository userRepository;

  @Override
  public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
    return this.userRepository.findByUsername(username).isEmpty()
        && username.matches("^[0-9a-z]{4,20}$");
  }
}
