package com.movieflix.Controller.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@NotEmpty(message = "titulo e obrigatorio")String title,
                           String description,

                           @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
                           @NotEmpty(message = "Data de lancamento e obrigatorio")LocalDate release_date,
                           double rating,
                           List<Long> categories,
                           List<Long> streaming){

}
