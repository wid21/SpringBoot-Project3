package com.example.springbootproject3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

   @NotEmpty(message = "name should not be empty")
   @Size(min = 2 , message = "name should be more 2 letters")
    private String name;

    @NotEmpty(message = "genre should not be empty")
    @Pattern(regexp = "^(Drama|Action|Comedy)$" ,message = "genre shouid be only Drama or Action or Comedy")
    @Column(columnDefinition = "varchar (10) not null check(genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre ;

    @NotNull(message = "rating should not be empty")
    @Min(value = 0,message = "the lowest rate is 1")
    @Max(value = 6,message = "the highest rate is 1")
    //@Column(columnDefinition = "int not null check (rating > 0 and rating < 6)")
    private int rating ;

    @NotNull(message = "duration should not be empty")
    @Min(value = 60,message = "the lowest duration for movie is 60 ")
    private double duration ;

    @NotNull(message = "directorID should not be null")
    //@Column(columnDefinition = "int not null")
    private int directorID;




}
