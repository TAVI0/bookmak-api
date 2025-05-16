package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserFollowPK implements Serializable {
    private Long idUser;
    private Long idFollowedUser;
}
