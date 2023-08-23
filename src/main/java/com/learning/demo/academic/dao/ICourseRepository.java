package com.learning.demo.academic.dao;

import com.learning.demo.academic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Integer> {}
