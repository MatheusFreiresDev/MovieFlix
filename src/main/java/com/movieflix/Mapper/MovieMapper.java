package com.movieflix.Mapper;

import com.movieflix.Controller.Request.MovieRequest;
import com.movieflix.Controller.Response.MovieResponse;
import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {


    public Movie toMovie(MovieRequest movieRequest) {

        List<Category> categorys = movieRequest.categories().stream().map(categoryId -> Category.builder().id(categoryId) .build()).toList();
        List<Streaming> streaming = movieRequest.streaming().stream().map(streamingId -> Streaming.builder().id(streamingId).build()).toList();
      return Movie.builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .release_date(movieRequest.release_date())
                .rating(movieRequest.rating())
                .categories(categorys)
              .streaming(streaming)
              .build();

    }



    public MovieResponse toMovieResponse(Movie movie) {
            List<String> categories = movie.getCategories().stream().map(category -> category.getName()).toList();
            List<String> streaming = movie.getStreaming().stream().map(streamings -> streamings.getName()).toList();
            return MovieResponse.builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .release_date(movie.getRelease_date())
                    .rating(movie.getRating())
                    .categories(categories)
                    .streaming(streaming)
                    .build();
    }

}
