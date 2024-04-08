package com.tavio.bookmarkapi.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name= "users")
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
