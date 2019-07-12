package com.dvd.Dvd.controler.errors;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity handleFilmNotFound(FilmNotFoundException ex) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
