package com.bloggish.springbloggish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggish.springbloggish.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
