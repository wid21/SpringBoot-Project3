package com.example.springbootproject3.Controller;

import com.example.springbootproject3.ApiException.ApiException;
import com.example.springbootproject3.Model.Movie;
import com.example.springbootproject3.Service.ServiceDirector;
import com.example.springbootproject3.Service.ServiceMovie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.util.Introspection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class ControllerMovie {

    private final ServiceMovie serviceMovie;
    private final ServiceDirector serviceDirector;

    @GetMapping("/get")
    public ResponseEntity getMovie() {
        List<Movie> movieList = serviceMovie.getMovies();
        return ResponseEntity.status(200).body(movieList);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie) {
        serviceMovie.addMovie(movie);
        return ResponseEntity.status(200).body("movie added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @RequestBody @Valid Movie movie) {
        serviceMovie.updateMovie(id, movie);
        return ResponseEntity.status(200).body("movie updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        serviceMovie.deleteMovie(id);
        return ResponseEntity.status(200).body("movie deleted");

    }

    @GetMapping("/search/{titel}")
    public ResponseEntity searchMovie(@PathVariable String titel) {
       Movie t= serviceMovie.searchM(titel);
        return ResponseEntity.status(200).body(t);

    }
    @GetMapping("/get/duration/{name}")
    public ResponseEntity getduration(@PathVariable String name){
       Movie a = serviceMovie.movieDura(name);
        return ResponseEntity.status(200).body("the duration of movie is " + a.getDuration());
    }

    @GetMapping("/get-rate/{name}")
    public ResponseEntity getRate(@PathVariable String name){
        Movie a = serviceMovie.movieRate(name);
        return ResponseEntity.status(200).body("the rate of movie is " + a.getRating());
    }

    @GetMapping("/get-hige-rate/{rate}")
    public ResponseEntity getrate (@PathVariable int rate){
        List<Movie>movieList=serviceMovie.getRate(rate);
        return ResponseEntity.status(200).body(movieList);
    }

    @GetMapping("/get-genre/{genre}")
    public ResponseEntity getrate (@PathVariable String genre){
        List<Movie>movieList=serviceMovie.getGenre(genre);
        return ResponseEntity.status(200).body(movieList);
    }


    @GetMapping("/get-director/{name}")
     public ResponseEntity DirectorName(@PathVariable String name ){
      return ResponseEntity.status(200).body("the director name is " + serviceMovie.DirectorName(name));
}


    @GetMapping("/get-director-movies/{nameDirector}")
    public ResponseEntity getMoviesForDirector(@PathVariable String nameDirector) {
        List<Movie> m = serviceMovie.getMoviesForDirector(nameDirector);
        return ResponseEntity.status(200).body(m);
    }





}

