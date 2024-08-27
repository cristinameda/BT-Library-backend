package com.bt.libraryapp.annotation.validator;

import com.bt.libraryapp.annotation.UniqueEmail;
import com.bt.libraryapp.repository.user.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
  private final UserRepository userRepository;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
    return userRepository.findByEmail(email).isEmpty();
  }
}
