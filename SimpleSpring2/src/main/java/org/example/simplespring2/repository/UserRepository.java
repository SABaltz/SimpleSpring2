package org.example.simplespring2.repository;

import org.example.simplespring2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

