package com.dvd.Dvd.Servises;

import com.dvd.Dvd.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
