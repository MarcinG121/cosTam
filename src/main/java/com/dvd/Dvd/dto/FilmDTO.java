package com.dvd.Dvd.dto;

import com.dvd.Dvd.model.Film;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private String title;
    private String description;
    private List<ActorDTO> actors;
    private List<CategoryDTO> filmCategories;

    public FilmDTO(Film filmObj) {
        this.title = filmObj.getTitle();
        this.description = filmObj.getDescription();
        actors = filmObj.getActors().stream()
                .map(actor -> new ActorDTO(actor.getName(), actor.getLastName()))
                .collect(Collectors.toList());
        filmCategories = filmObj.getFilmCategories().stream()
                .map(category -> new CategoryDTO(category.getCategoryName()))
                .collect(Collectors.toList());
    }


}
