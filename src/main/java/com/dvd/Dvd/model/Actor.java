package com.dvd.Dvd.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_actor_id_seq")
    private long actorId;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private List<Film> films;

    public Actor(long actorId, String name, String lastName, List<Film> flims) {
        this.actorId = actorId;
        this.name = name;
        this.lastName = lastName;
        this.films = flims;
    }

    public Actor(String name, String lastName, Film film) {
        this.name = name;
        this.lastName = lastName;
        this.films = new ArrayList<Film>();
        this.films.add(film);
    }

    public void addFilms(Film film){
        this.films.add(film);
    }
//    @PostPersist
//    public void populateFilms() {
//        for (Film film : films){
//            film.addActor(this);
//        }
//    }



    public long getActorId() {
        return actorId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
