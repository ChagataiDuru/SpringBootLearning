package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO {
    User save(User student);
    User findById(int id);
    void deleteById(int id);
    List<User> findAll();
    List<User> findStudentsWithOzuEmail();
    User update(User user);
}
