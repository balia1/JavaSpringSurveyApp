package com.sempertech.MySqlProject.repository;

import com.sempertech.MySqlProject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
