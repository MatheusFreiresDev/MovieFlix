package com.movieflix.Repository;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

 List<Movie> findAllByOrderByRatingDesc();
    List<Movie> findAllByCategories_Id(Long categoryId);

}
