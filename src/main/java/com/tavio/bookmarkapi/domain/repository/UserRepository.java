package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.crud.UserCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getById(int idUser){
        return userCrudRepository.findById(idUser);
    }
}
