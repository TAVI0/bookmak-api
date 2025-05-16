package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "user_role")
@IdClass(UserRoleId.class)
@Data
@Entity
public class UserRoleEntity {

    @Id
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Id
    @Column(nullable = false, length = 20)
    private String role;

    @Column(name = "granted_date", nullable = false)
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false)
    private UserEntity user;

}
