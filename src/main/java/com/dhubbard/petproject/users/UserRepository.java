package com.dhubbard.petproject.users;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);
}
