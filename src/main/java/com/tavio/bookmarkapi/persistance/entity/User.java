package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;


@Entity
@Table(name= "users")
@Data
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String role;
    private String description;
    private String twitter;

   /*
    @OneToMany(mappedBy = "user")
    private List<Post> posts;



    @OneToMany(mappedBy = "user")
    private List<UserLike> likes;
*/
    @OneToMany(mappedBy = "user")
    private List<UserFollow> follows;

    @OneToMany(mappedBy = "idFollowedUser")
    private List<UserFollow> followers;


}
