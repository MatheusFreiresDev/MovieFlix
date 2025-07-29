package com.movieflix.Service;

import com.movieflix.Controller.Request.CategoryRequest;
import com.movieflix.Controller.Request.MovieRequest;
import com.movieflix.Controller.Response.MovieResponse;
import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    CategoryService categoryService;
    StreamingService streamingService;

    public Movie save(Movie movie) {
        movie.setCategories(foundCategorys(movie.getCategories()));
        movie.setStreaming(foundStreaming(movie.getStreaming()));
        return movieRepository.save(movie);
    }

    public List<Movie> list(){
        return movieRepository.findAllByOrderByRatingDesc();
    }
    public Movie movie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
    public Movie alterar(Long id, Movie movie) {
        movie.setId(id);
        Movie atualizado = save(movie);
        Movie movieComRelacionamentos = movieRepository.findById(atualizado.getId()).orElse(null);
        return movieComRelacionamentos;

    }


    public List<Category> foundCategorys(List<Category> categories){
        List<Category> categoriesFounded = categories.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return categoriesFounded;
    }

    public List<Streaming> foundStreaming(List<Streaming> streamings){
        List<Streaming> streamingsFounded = streamings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return streamingsFounded;
    }


    public List<Movie> byCategory(Long id) {
        return movieRepository.findAllByCategories_Id(id);
    }
}
