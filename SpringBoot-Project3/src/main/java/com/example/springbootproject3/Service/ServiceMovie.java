package com.example.springbootproject3.Service;

import com.example.springbootproject3.ApiException.ApiException;
import com.example.springbootproject3.Model.Director;
import com.example.springbootproject3.Model.Movie;
import com.example.springbootproject3.Repository.RepositoryDirector;
import com.example.springbootproject3.Repository.RepositoryMovie;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMovie {

    private final RepositoryMovie repositoryMovie;
    private final RepositoryDirector repositoryDirector;

    public List<Movie> getMovies() {
        List<Movie> movieList = repositoryMovie.findAll();
        return movieList;
    }

    public void addMovie(Movie movie) {
        repositoryMovie.save(movie);
    }

    public void updateMovie(Integer id, Movie movie) {
        Movie m = repositoryMovie.findMovieById(id);
        if (m == null) {
            throw new ApiException("not found");
        }
        m.setName(movie.getName());
        m.setGenre(movie.getGenre());
        m.setRating(movie.getRating());
        m.setDuration(movie.getDuration());
        m.setDirectorID(movie.getDirectorID());
        repositoryMovie.save(m);
    }

    public void deleteMovie(Integer id) {
        Movie m = repositoryMovie.findMovieById(id);
        if (m == null) {
            throw new ApiException("not found");
        }
        repositoryMovie.delete(m);
    }

    public Movie searchM(String titel) {
        Movie t = repositoryMovie.findMovieByName(titel);
        if (t == null) {
            throw new ApiException("not found");
        }
        return t;
    }

    public Movie movieDura(String name) {
        Movie d = repositoryMovie.findMovieByName(name);
        if (d == null) {
            throw new ApiException("not found");
        }
        return d;

    }
    public Movie movieRate(String name) {
        Movie d = repositoryMovie.findMovieByName(name);
        if (d == null) {
            throw new ApiException("not found");
        }
        return d;
    }

    public List<Movie> getRate(int rate){
        List<Movie> movieList=repositoryMovie.getRate(rate);
        if(rate <0 || rate > 5){
            throw new ApiException("invalid rate");
        }
        return movieList;
    }
    public List<Movie> getGenre(String genre) {
        List<Movie> movieList = repositoryMovie.getAllGenre(genre);
        return movieList;
    }

    public String DirectorName(String name){
        if(repositoryMovie.findMovieByName(name)==null){
            throw new ApiException("We do not have movie with this name ");
    }
        return repositoryDirector.findDirectorById(repositoryMovie.findMovieByName(name).getDirectorID()).getName();
    }

    public List<Movie> getMoviesForDirector(String nameDirector) {
        Director a = repositoryDirector.findDirectorByName(nameDirector);
        List<Movie> d = repositoryMovie.findMovieByDirectorID(a.getId());
        if (d==null) {
            throw new ApiException("we do not have movies for this director");
        }
        return d;

    }

}
