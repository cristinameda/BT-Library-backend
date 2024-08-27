package com.bt.libraryapp.dto.response.auth;

import com.bt.libraryapp.dto.response.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
  private UserResponse userResponse;
  private String token;
}
