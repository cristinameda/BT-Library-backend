package com.bt.libraryapp.annotation.validator;

import com.bt.libraryapp.annotation.UniquePhoneNo;
import com.bt.libraryapp.repository.user.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniquePhoneNoValidator implements ConstraintValidator<UniquePhoneNo, String> {
  private final UserRepository userRepository;

  @Override
  public boolean isValid(String phoneNo, ConstraintValidatorContext constraintValidatorContext) {
    return this.userRepository.findByPhoneNo(phoneNo).isEmpty()
        && phoneNo.matches(
            "^(\\+4|)?(07[0-8][0-9]|02[0-9]{2}|03[0-9]{2})(\\s|\\.|-)?([0-9]{3}(\\s|\\.|-|)){2}$");
  }
}
