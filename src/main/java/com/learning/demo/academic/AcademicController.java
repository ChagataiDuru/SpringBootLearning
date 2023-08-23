package com.learning.demo.academic;


import com.learning.demo.academic.entity.Course;
import com.learning.demo.academic.service.CourseService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(name = "courses")
public class AcademicController {

    private final CourseService courseService;

    public AcademicController(CourseService courseService){this.courseService = courseService;}

    @GetMapping
    public List<Course> findAllCourses(@RequestParam(value = "page", defaultValue = "0") int page) {
        int SIZE = 10;
        return this.courseService.findAll();
    }

    @GetMapping("{id}")
    public Course findById(@PathVariable int id){
        return this.courseService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id){
        this.courseService.deleteById(id);
    }



}
