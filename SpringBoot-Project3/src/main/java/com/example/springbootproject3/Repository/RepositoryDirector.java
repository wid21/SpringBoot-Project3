package com.example.springbootproject3.Repository;

import com.example.springbootproject3.Model.Director;
import com.example.springbootproject3.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDirector extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);

    Director findDirectorByName(String name);

}
