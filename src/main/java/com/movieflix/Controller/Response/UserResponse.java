package com.movieflix.Controller.Response;

import lombok.Builder;

@Builder
public record UserResponse(String name,String email, String password) {
}
