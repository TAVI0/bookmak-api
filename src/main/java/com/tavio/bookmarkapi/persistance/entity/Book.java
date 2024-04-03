package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String writer;

    @OneToMany(mappedBy = "book")
    private List<Post> posts;
}
