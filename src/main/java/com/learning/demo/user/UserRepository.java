package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository implements UserDAO{
    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public User save(User student){
        entityManager.persist(student);
        return student;
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        User student = entityManager.find(User.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public Page<User> findAll(PageRequest of) {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .setFirstResult(of.getOffset())
                .setMaxResults(of.getPageSize())
                .getResultList();
    }

    @Override
    @Transactional
    public User update(User user) {

    }
}
