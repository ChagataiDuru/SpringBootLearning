package com.learning.demo.academic;

import com.learning.demo.academic.entity.Course;
import com.learning.demo.user.entity.User;

import java.util.List;

public interface AcademicDAO {

    public void registerStudents(Course course, List<User> students);
    public void removeStudent(User student);


}
