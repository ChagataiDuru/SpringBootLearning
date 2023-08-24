package com.learning.demo.academic.service;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.academic.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    @Autowired
    public CourseService(ICourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> res = this.courseRepository.findById(id);
        Course course = null;
        if (res.isPresent()){
            course = res.get();
        }else{
            throw new RuntimeException("Cant find the course id " + id);
        }
        return course;
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
