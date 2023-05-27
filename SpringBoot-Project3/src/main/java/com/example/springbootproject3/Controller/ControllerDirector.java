package com.example.springbootproject3.Controller;

import com.example.springbootproject3.Model.Director;
import com.example.springbootproject3.Service.ServiceDirector;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class ControllerDirector {

    private final ServiceDirector serviceDirector;

    @GetMapping("/get")
    public ResponseEntity getDirectors() {
        List<Director> list = serviceDirector.getDirectors();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/add")
    public ResponseEntity addDirectors(@Valid @RequestBody Director director) {
        serviceDirector.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirectors(@PathVariable Integer id, @Valid @RequestBody Director director) {
        serviceDirector.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirectors (@PathVariable Integer id){
        serviceDirector.deleteDirectotre(id);
        return ResponseEntity.status(200).body("Director deleted");
    }
}

