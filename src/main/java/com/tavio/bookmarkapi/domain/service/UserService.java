package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.domain.repository.UserRepository;
import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.getByUsername(username);
    }
    public Optional<User> getById(Integer id){
        return userRepository.getById(id);
    }
    public List<User> getAll(){
        return userRepository.getAll();
    }

}
