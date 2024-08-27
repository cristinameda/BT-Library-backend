package com.bt.libraryapp.dto.response.user;

import com.bt.libraryapp.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
  private long id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNo;
  private UserRole role;
}
