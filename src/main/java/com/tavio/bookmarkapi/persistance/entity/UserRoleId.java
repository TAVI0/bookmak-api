package com.tavio.bookmarkapi.persistance.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class UserRoleId implements Serializable {
    private Integer idUser;
    private String role;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof UserRoleId that)) return false;
        return Objects.equals(idUser, that.idUser) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode(){
        return Objects.hash(idUser, role);
    }
}
