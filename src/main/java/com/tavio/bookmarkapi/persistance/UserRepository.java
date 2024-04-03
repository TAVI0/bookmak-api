package com.tavio.bookmarkapi.persistance;

import com.tavio.bookmarkapi.persistance.crud.UserCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getById(int idUser){
        return userCrudRepository.findById(idUser);
    }
}
