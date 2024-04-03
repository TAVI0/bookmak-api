package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users_likes")
public class UserLike {
    @EmbeddedId
    private UserLikePK id;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idPost", insertable = false, updatable = false)
    private Post post;
}
