package com.dvd.Dvd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "film")
public class Film {

    @Id
    private long filmId;
    private String title;
    private String description;
    @ManyToMany
            @JoinTable(
                    name = "film_actor",
                    joinColumns = @JoinColumn(name = "filmId"),
                    inverseJoinColumns = @JoinColumn(name = "actorId")
            )
    @JsonManagedReference
    private List<Actor> actors;
    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "filmId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> filmCategories;

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }



}
