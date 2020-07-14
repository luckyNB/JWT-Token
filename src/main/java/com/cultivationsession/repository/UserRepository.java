package com.cultivationsession.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cultivationsession.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
Optional<User> findByEmailId(String emailId);

}
