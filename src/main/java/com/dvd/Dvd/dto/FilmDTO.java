package com.dvd.Dvd.dto;

import com.dvd.Dvd.model.Actor;
import com.dvd.Dvd.model.Category;
import com.dvd.Dvd.model.Film;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class FilmDTO {

    private String title;
    private String description;
    private List<ActorDTO> actors;
    private List<CategoryDTO> filmCategories;

    public FilmDTO(Optional<Film> film) {
        Film filmObj = film.get();
        this.title = filmObj.getTitle();
        this.description = filmObj.getDescription();
        List<Actor> actorsNoDTO = filmObj.getActors();
        actors = new ArrayList<>();
        for (Actor actor : actorsNoDTO){
            actors.add(new ActorDTO(actor.getName(), actor.getLastName()));
        }
        List<Category> categoryNoDTO = filmObj.getFilmCategories();
        filmCategories = new ArrayList<>();
        for (Category category : categoryNoDTO){
            filmCategories.add(new CategoryDTO(category.getCategoryName()));
        }

    }

}
