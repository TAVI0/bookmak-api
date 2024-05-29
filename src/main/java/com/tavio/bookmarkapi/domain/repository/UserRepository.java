package com.tavio.bookmarkapi.domain.repository;

import com.tavio.bookmarkapi.persistance.crud.UserCrudRepository;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    public Optional<User> getById(int idUser){
        return userCrudRepository.findById(idUser);
    }
    public Optional<User> getByUsername(String username){
        return userCrudRepository.findByUsername(username);
    }
    public User save(User user){
        return userCrudRepository.save(user);
    }
}
