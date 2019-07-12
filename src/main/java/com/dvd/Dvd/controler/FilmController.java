package com.dvd.Dvd.controler;


import com.dvd.Dvd.dto.ActorDTO;
import com.dvd.Dvd.model.Actor;
import com.dvd.Dvd.servises.*;
import com.dvd.Dvd.controler.errors.FilmNotFoundException;
import com.dvd.Dvd.dto.FilmDTO;
import com.dvd.Dvd.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FilmController {

    @Autowired
    FilmRepository repository;
    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/films/{id}")
    public FilmDTO getFilmById(@PathVariable(required = true) long id) {

        Film film = repository.findById(id).orElseThrow(() -> new FilmNotFoundException("Film not found"));

        return new FilmDTO(film);
    }

    @GetMapping("films/info/{id}")
    public Optional<FilmData> getLessInfoAboutFilmById(@PathVariable(required = true) long id) {

        return repository.findByFilmId(id);
    }

    @GetMapping("films/{id}/actors")
    public List<ActorName> getActorById(@PathVariable(required = true) long id) {

        return actorRepository.findByFilms_filmId(id);
    }

    @GetMapping("/films")
    @ResponseBody
    public List<FilmData> getFilmByParameters(@RequestParam(required = false) String title) {


        return repository.findByTitleLikeIgnoreCase(title + "%");
    }

//    @GetMapping("/films")
//    @ResponseBody
//    public List<FilmData> getFilmByParametersTrying(@RequestParam(required = false) String title) {
//
//
//        return repository.findByParameterTitle(title);
//    }

    @GetMapping("/films/actors")
    @ResponseBody
    public List<ActorName> getFilmByParametersTryingName(@RequestParam(required = false, name = "name") String namePatern) {

        return actorRepository.findByParameterName(namePatern);
    }

    @GetMapping("/films/fullInfo")
    @ResponseBody
    public List<FullFilm> getFilmByParametersTryingFull(@RequestParam(required = false) String title, @RequestParam(required = false) String name) {

        return repository.findByParameter(title, name);
    }

    @PutMapping("/films/{id}")
    @ResponseBody
    public ResponseEntity<Object> createFilm(@RequestBody FilmDTO requestBody, @PathVariable long id){

        Film film = repository.findById(id).orElseThrow(() -> new FilmNotFoundException("Film not found"));

        film.setTitle(requestBody.getTitle());
        film.setDescription(requestBody.getDescription());

        repository.save(film);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/films/{id}/actors")
    @ResponseBody
    public ResponseEntity<Object> updateFilmActors(@RequestBody ActorDTO requestBody, @PathVariable long id){

        Film film = repository.findById(id).orElseThrow(() -> new FilmNotFoundException("Film not found"));

        Actor actor = new Actor(requestBody.getName(), requestBody.getLastName(), film);
        film.addActor(actor);
        actorRepository.save(actor);
        repository.save(film);


        return ResponseEntity.noContent().build();
    }

}




