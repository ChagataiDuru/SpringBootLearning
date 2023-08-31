package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM Student u ")
    List<User> findStudentsWithOzuEmail();
}
