package com.movieflix.Controller.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.random.RandomGenerator;

@Builder
public record MovieResponse(Long id, String title,
                            @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
                            LocalDate release_date,
                            double rating,List<String> categories,
                            List<String> streaming
) {
}
