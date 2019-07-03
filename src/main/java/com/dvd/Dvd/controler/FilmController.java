package com.dvd.Dvd.controler;


import com.dvd.Dvd.Servises.ActorRepository;
import com.dvd.Dvd.Servises.FilmRepository;
import com.dvd.Dvd.model.Actor;
import com.dvd.Dvd.model.Category;
import com.dvd.Dvd.model.Film;
import com.dvd.Dvd.dto.FilmDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/welcome")
public class FilmController {

    @Autowired
    FilmRepository service;
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping
    public String helloWorld() {

        String message = "Hello World";
        JSONObject jo = new JSONObject(
                "{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}"
        );

        return jo.toString();
    }

    @GetMapping("/{id}")
    public FilmDTO getById(@PathVariable(required = true) long id) throws Throwable{

        FilmDTO filmDTO = new FilmDTO(service.findById(id));

        return filmDTO;
    }
}




