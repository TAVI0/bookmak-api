package com.tavio.bookmarkapi.persistance.crud;

import com.tavio.bookmarkapi.persistance.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    List<User> findByRoleOrderByIdAsc(String Role);
}
