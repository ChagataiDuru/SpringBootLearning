package com.learning.demo.user.dao;

import com.learning.demo.user.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void save(Student student){
        entityManager.persist(student);
    }
}
