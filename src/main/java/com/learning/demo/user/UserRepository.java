package com.learning.demo.user;

import com.learning.demo.user.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository implements UserDAO{
    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public User save(User user){
        entityManager.persist(user);
        return user;
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
    public List<User> findAll() {
        return (List<User>) this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public List<User> findStudentsWithOzuEmail() {
        String emailKeyword = "@ozu.edu.tr";
        String hql = "FROM User u WHERE u.email LIKE :emailKeyword";
        Query<User> query = (Query<User>) this.entityManager.createQuery(hql, User.class);
        query.setParameter("emailKeyword", "%" + emailKeyword + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public User update(User user) {
        return null;
    }
}
