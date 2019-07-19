package com.dvd.Dvd.repository;

import com.dvd.Dvd.model.Actor;
import com.dvd.Dvd.projection.actor.ActorName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<ActorName> findByActorId(long id);
    List<ActorName> findByName(String name);
    List<ActorName> findByFilms_filmId(long id);

    @Query(value = "SELECT first_name as name, last_name as lastName FROM actor WHERE first_name LIKE :name%" , nativeQuery = true)
    List<ActorName> findByParameterName(@Param("name") String name);
}
