package com.movieflix.Controller.Request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Nome de login e obrigatorio")String email,@NotEmpty(message = "senha e obrigatorio") String password) {
}
