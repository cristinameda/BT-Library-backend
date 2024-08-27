package com.bt.libraryapp.repository.user;

import com.bt.libraryapp.entity.User;
import com.bt.libraryapp.entity.UserRole;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  Optional<User> findByUsername(String username);

  Optional<User> findByPhoneNo(String phoneNo);

  List<User> findAllByRole(UserRole role);
}
