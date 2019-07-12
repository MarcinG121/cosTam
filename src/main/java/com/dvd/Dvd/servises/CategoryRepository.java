package com.dvd.Dvd.servises;

import com.dvd.Dvd.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
