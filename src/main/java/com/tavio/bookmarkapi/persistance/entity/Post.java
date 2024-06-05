package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private Integer idUser;
    private Integer idBook;
    @Column(name="date_post")
    private Date datePost;
    @Column(name="date_start")
    private Date dateStart;
    @Column(name="date_end")
    private Date dateEnd;
    private String review;
    private Integer rated;
    private boolean spoiler;
    private boolean liked;
    private boolean readBefore;


    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "idBook", insertable = false, updatable = false)
    private Book book;

  /*  @OneToMany(mappedBy = "post")
    private List<UserLike> usersLike;
   */

}
