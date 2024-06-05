package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users_follows")
public class UserFollow {
    @EmbeddedId
    private UserFollowPK id;

    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "idFollowedUser", insertable = false, updatable = false)
    private UserEntity idFollowedUser;
}
