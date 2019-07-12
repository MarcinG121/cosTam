package com.dvd.Dvd.controler.errors;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class FilmNotFoundException extends RuntimeException{

    public FilmNotFoundException(String message) {
        super(message);
    }
}
