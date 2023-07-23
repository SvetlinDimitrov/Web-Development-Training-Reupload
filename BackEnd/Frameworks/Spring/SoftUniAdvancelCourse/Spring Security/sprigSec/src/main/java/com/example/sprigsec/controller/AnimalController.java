package com.example.sprigsec.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AnimalController {

    @GetMapping("/cat")
    public ResponseEntity<String> getCat(){
        return new ResponseEntity<>("Hello i am cat",HttpStatus.OK);
    }
    @GetMapping("/dog")
    public ResponseEntity<String> getDog(){
        return new ResponseEntity<>("Hello i am dog",HttpStatus.OK);
    }
}
