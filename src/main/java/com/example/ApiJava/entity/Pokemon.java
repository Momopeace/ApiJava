package com.example.ApiJava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name= "Pokemon")
public class Pokemon {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;
@Column(columnDefinition = "varchar(40) NOT NULL")
private String name;
@Column(columnDefinition = "varchar(40) NOT NULL")
private String genre;

public Pokemon() {}

public Pokemon(int id, String name, String genre) {
    this.setId(id);
    this.setName(name);
    this.setGenre(genre);
}



public Pokemon(String name, String genre) {
    this.setName(name);
    this.setGenre(genre);
}

public int getId() {
    return this.id;
}
public void setId(int id) {
    this.id = id;
}

public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}

public String getGenre() {
    return this.genre;
}
public String setGenre(String genre) {
    return this.genre = genre;
}
 


}
