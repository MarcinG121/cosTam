package com.dvd.Dvd.projection.film;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.persistence.OrderColumn;
import java.util.List;

public interface FullFilm {

    String getDescription();
    String getLastName();
    String getName();
    String getTitle();
}
