package com.example.egzamin.repository;

import com.example.egzamin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Users,Long> {
    Users findByLogin(String login);
}
