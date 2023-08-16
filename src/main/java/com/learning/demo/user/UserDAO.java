package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserDAO {
    User save(User student);
    User findById(int id);
    void deleteById(int id);
    Page<User> findAll(PageRequest of);
    User update(User user);
}
