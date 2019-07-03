package com.dvd.Dvd.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    private long actorId;
    @Column(name = "first_name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @ManyToMany(mappedBy = "actors")
    private List<Film> flims;

    public Actor(long actorId, String name, String lastName, List<Film> flims) {
        this.actorId = actorId;
        this.name = name;
        this.lastName = lastName;
        this.flims = flims;
    }

    public long getActorId() {
        return actorId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Film> getFlims() {
        return flims;
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

    public void setFlims(List<Film> flims) {
        this.flims = flims;
    }

}
