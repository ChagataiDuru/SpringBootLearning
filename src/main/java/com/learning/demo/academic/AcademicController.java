package com.learning.demo.academic;


import com.learning.demo.academic.entity.Course;
import com.learning.demo.academic.repository.CourseRepository;
import com.learning.demo.user.UserDAO;
import com.learning.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(name = "courses")
public class AcademicController {

    private final CourseRepository courseRepository;

    public AcademicController(CourseRepository courseRepository){this.courseRepository = courseRepository;}

    @GetMapping
    public List<Course> findAllCourses(@RequestParam(value = "page", defaultValue = "0") int page) {
        int SIZE = 10;
        return this.courseRepository.findAll(PageRequest.of(page, SIZE, Sort.by("first_name", "id")));
    }

    

}
