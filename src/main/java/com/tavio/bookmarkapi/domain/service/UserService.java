package com.tavio.bookmarkapi.domain.service;

import com.tavio.bookmarkapi.domain.repository.UserRepository;
import com.tavio.bookmarkapi.persistance.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<UserEntity> getById(Integer id){
        return userRepository.findById(id);
    }
    public List<UserEntity> getAll(){
        return (List<UserEntity>) userRepository.findAll();
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

}
