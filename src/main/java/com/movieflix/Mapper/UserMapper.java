package com.movieflix.Mapper;

import com.movieflix.Controller.Request.UserRequest;
import com.movieflix.Controller.Response.UserResponse;
import com.movieflix.Entity.User;
import lombok.experimental.UtilityClass;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

@UtilityClass
public class UserMapper {

    public User toUser(UserRequest userRequest){
        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public UserResponse toUserResponse (User user){
            return UserResponse.builder()
                    .name(user.getName())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .build();
    }


}
