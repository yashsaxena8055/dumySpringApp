package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDB extends JpaRepository<User,Integer> {
}
