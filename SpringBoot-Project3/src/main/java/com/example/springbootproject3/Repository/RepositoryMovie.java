package com.example.springbootproject3.Repository;

import com.example.springbootproject3.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMovie extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);
    Movie findMovieByName(String name);

    @Query("select r from Movie r where r.rating > ?1")
    List <Movie> getRate(int rate);

    @Query("select g from Movie g where g.genre = ?1")
    List<Movie> getAllGenre(String genre);

    List<Movie> findMovieByDirectorID(int director);

}
