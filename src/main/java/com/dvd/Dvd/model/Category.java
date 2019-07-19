package com.dvd.Dvd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    private long categoryId;
    @Column(name = "name")
    private String categoryName;
    @ManyToMany(mappedBy = "filmCategories")
    @JsonBackReference
    private List<Film> filmList;

}
