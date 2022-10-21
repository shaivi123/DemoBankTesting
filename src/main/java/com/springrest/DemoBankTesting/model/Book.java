package com.springrest.DemoBankTesting.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private int id;
    private String title;
    private int price;
//    private LocalDate publishedDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
