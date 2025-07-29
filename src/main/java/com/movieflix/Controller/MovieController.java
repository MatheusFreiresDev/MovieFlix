package com.movieflix.Controller;

import com.movieflix.Controller.Request.MovieRequest;
import com.movieflix.Controller.Response.MovieResponse;
import com.movieflix.Mapper.MovieMapper;
import com.movieflix.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody MovieRequest movieRequest){
        MovieResponse  response =  MovieMapper.toMovieResponse(movieService.save(MovieMapper.toMovie(movieRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        List<MovieResponse> list = movieService.list().stream().map(MovieMapper::toMovieResponse).toList();
        if(list.isEmpty()) {
            return ResponseEntity.ok("Nao ha registros.");
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id) {
        MovieResponse movieResponse = MovieMapper.toMovieResponse(movieService.movie(id));
        if(movieResponse != null) {
            return ResponseEntity.ok(movieResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe esse id no nossos registros");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        MovieResponse movieResponse = MovieMapper.toMovieResponse(movieService.movie(id));
        if(movieResponse != null) {
            movieService.delete(id);
            return ResponseEntity.ok("O filme - " + movieResponse.title() + " foi removido.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe esse id no nossos registros");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atlerar(@PathVariable Long id, @RequestBody MovieRequest movieRequest) {
      if(movieService.movie(id) != null) {
          return ResponseEntity.ok( movieService.alterar(id,MovieMapper.toMovie(movieRequest)));
      }
      else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe esse id no nossos registros");
      }
    }

    @GetMapping("/search")
    public ResponseEntity<?> byCategory(@RequestParam Long id) {
        return ResponseEntity.ok(movieService.byCategory(id));
    }


}
