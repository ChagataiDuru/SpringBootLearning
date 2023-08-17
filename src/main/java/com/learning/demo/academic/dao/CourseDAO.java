package com.learning.demo.academic.dao;

import com.learning.demo.academic.entity.Course;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CourseDAO {
    Course save(Course course);

    Course findById(long id);

    void deleteById(long id);

    List<Course> findAll(PageRequest of);

    Course update(Course course);



}
