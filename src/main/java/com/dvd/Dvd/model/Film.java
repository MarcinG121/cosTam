package com.dvd.Dvd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
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

    public Film(long filmId, String title, String description, List<Actor> actors, List<Category> categories) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.filmCategories = categories;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

//    @PostPersist
//    public void populateActors() {
//        for(Actor actor: actors){
//            actor.addFilms(this);
//        }
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getFilmId() {
        return filmId;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Category> getFilmCategories() {
        return filmCategories;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setFilmCategories(List<Category> filmCategories) {
        this.filmCategories = filmCategories;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + actors +
                ", filmCategories=" + filmCategories +
                '}';
    }

}
