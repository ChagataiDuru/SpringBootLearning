package com.learning.demo.academic.repository;

import com.learning.demo.academic.dao.CourseDAO;
import com.learning.demo.academic.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseRepository implements CourseDAO {

    private final EntityManager entityManager;

    @Autowired
    public CourseRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Course save(Course course) {
        this.entityManager.persist(course);
        return course;
    }

    @Override
    public Course findById(long id) {
        return this.entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteById(long id) {

    }

    @Override
    public List<Course> findAll(PageRequest of) {
        return null;
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return null;
    }
}
