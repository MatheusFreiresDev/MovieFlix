package com.movieflix.Controller.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Nome da categoria e obrigatorio") String name) {
}
