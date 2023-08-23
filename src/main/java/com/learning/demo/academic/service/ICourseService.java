package com.learning.demo.academic.service;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.academic.entity.Course;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ICourseService{

    List<Course> findAll();

    Course findById(Integer integer);

    Course save(Course course);

    void deleteById(Integer integer);
}
