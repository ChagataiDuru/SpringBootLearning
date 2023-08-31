package com.learning.demo.academic;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.academic.entity.Course;
import com.learning.demo.user.IUserRepository;
import com.learning.demo.user.entity.Student;
import com.learning.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AcademicRepository implements AcademicDAO {

    private final ICourseRepository courseRepository;
    private IUserRepository IUserRepository;

    @Autowired
    public AcademicRepository(ICourseRepository courseRepository, IUserRepository IUserRepository) {
        this.courseRepository = courseRepository;
        this.IUserRepository = IUserRepository;
    }

    @Override
    @Transactional
    public void registerStudents(Course course, List<User> students) {
        //course.setStudents(students);
        for (User u : students) {
            if (u instanceof Student student) {
                course.getStudents().add(student);
                student.setCourse(course);
                IUserRepository.save(student);
            }
        }
        System.out.println("AAAAAAA"+course.getStudents().size());
    }

    @Override
    @Transactional
    public void removeStudent(User student) {
        ((Student)student).setCourse(null);
    }




}





