package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private Integer idUser;
    private Integer idBook;
    private Date date;
    private String review;
    private Integer rated;
    private boolean spoiler;
    private boolean liked;
    private boolean readBefore;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idBook", insertable = false, updatable = false)
    private Book book;

    @OneToMany(mappedBy = "post")
    private List<UserLike> usersLike;


}
