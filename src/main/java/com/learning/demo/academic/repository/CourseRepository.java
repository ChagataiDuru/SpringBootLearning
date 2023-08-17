package com.learning.demo.academic.repository;

import com.learning.demo.academic.dao.CourseDAO;
import com.learning.demo.academic.entity.Course;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseRepository implements CourseDAO {
    @Override
    @Transactional
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course findById(long id) {
        return null;
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
