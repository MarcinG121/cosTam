package com.dvd.Dvd.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
@Getter
@Setter
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

    public Actor(String name, String lastName, Film film) {
        this.name = name;
        this.lastName = lastName;
        this.films = new ArrayList<Film>();
        this.films.add(film);
    }

    public void addFilms(Film film){
        this.films.add(film);
    }
}
