package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserLikePK implements Serializable {
    private Integer idUser;
    private Integer idPost;
}
