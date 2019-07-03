package com.dvd.Dvd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "category")
public class Category {

    @Id
    private long categoryId;
    @Column(name = "name")
    private String categoryName;
    @ManyToMany(mappedBy = "filmCategories")
    private List<Film> filmList;


    public Category(long categoryId, String categoryName, List<Film> filmList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.filmList = filmList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
