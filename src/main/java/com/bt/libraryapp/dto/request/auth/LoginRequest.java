package com.bt.libraryapp.dto.request.auth;

import com.bt.libraryapp.annotation.Password;
import com.bt.libraryapp.annotation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
  @UniqueUsername private String username;
  @Password private String password;
}
