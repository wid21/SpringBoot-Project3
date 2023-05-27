package com.example.springbootproject3.Service;

import com.example.springbootproject3.ApiException.ApiException;
import com.example.springbootproject3.Model.Director;
import com.example.springbootproject3.Repository.RepositoryDirector;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ServiceDirector {

    private final RepositoryDirector repositoryDirector;

    public List<Director> getDirectors(){
        List<Director> directorList=repositoryDirector.findAll();
        return  directorList;
    }

    public void addDirector(Director director){

        repositoryDirector.save(director);
    }

    public void updateDirector(Integer id , Director director){
        Director d = repositoryDirector.findDirectorById(id);
        if(d==null){
            throw new ApiException("not found");
        }
        d.setName(director.getName());
        repositoryDirector.save(d);
    }
    public void deleteDirectotre(Integer id){
        Director d = repositoryDirector.findDirectorById(id);
        if(d==null){
            throw new ApiException("not found");
        }
        repositoryDirector.delete(d);
    }
}
