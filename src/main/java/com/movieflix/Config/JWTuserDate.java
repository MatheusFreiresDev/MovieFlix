package com.movieflix.Config;

import lombok.Builder;

@Builder
public record JWTuserDate (Long id,String name,String email,String password){
}
