package com.bt.libraryapp.mapper.user;

import com.bt.libraryapp.dto.request.user.CreateUserRequest;
import com.bt.libraryapp.dto.response.user.UserResponse;
import com.bt.libraryapp.entity.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
  @Mapping(target = "id", ignore = true)
  User createUserRequestToUser(CreateUserRequest createUserRequest);

  UserResponse userToUserResponse(User user);

  List<UserResponse> usersToUserResponses(List<User> users);
}
