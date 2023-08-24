package com.learning.demo.academic;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.academic.entity.Course;
import com.learning.demo.user.UserDAO;
import com.learning.demo.user.entity.Student;
import com.learning.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AcademicRepository implements AcademicDAO {

    private final ICourseRepository courseRepository;

    @Autowired
    public AcademicRepository(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void registerStudents(Course course, List<User> students) {
        course.setStudents(students);
        courseRepository.save(course);
        for (User u : students) {
            if (u instanceof Student student) {
               student.setCourse(course);
            }
        }
    }

    @Override
    @Transactional
    public void removeStudent(User student) {
        ((Student)student).setCourse(null);
    }




}





