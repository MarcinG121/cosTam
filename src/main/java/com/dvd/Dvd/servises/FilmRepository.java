package com.dvd.Dvd.servises;


import com.dvd.Dvd.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<FilmData> findByFilmId(long id);
    List<FilmData> findByTitle(String title);
    List<FilmData> findByTitleLikeIgnoreCase(String title);
    @Query(value = "SELECT f.title, f.description FROM Film f WHERE f.title LIKE :title%" , nativeQuery = true)
    List<FilmData> findByParameterTitle(@Param("title") String title);
    @Query(value = "SELECT description, last_name as lastName, first_name as name, title " +
            "FROM film_actor " +
            "INNER JOIN actor ON actor.actor_id = film_actor.actor_id " +
            "INNER JOIN film ON film.film_id = film_actor.film_id " +
            "WHERE first_name LIKE :name% AND title LIKE :title%", nativeQuery = true)
    List<FullFilm> findByParameter(@Param("title") String title, @Param("name") String name);
}

