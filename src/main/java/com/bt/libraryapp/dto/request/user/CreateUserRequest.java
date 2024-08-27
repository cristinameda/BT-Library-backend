package com.bt.libraryapp.dto.request.user;

import com.bt.libraryapp.annotation.UniqueEmail;
import com.bt.libraryapp.annotation.UniquePhoneNo;
import com.bt.libraryapp.annotation.UniqueUsername;
import com.bt.libraryapp.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @UniqueUsername @NotBlank private String username;
  @UniqueEmail @Email @NotBlank private String email;
  @NotBlank private String password;
  @UniquePhoneNo @NotBlank private String phoneNo;
  private UserRole role;
}
