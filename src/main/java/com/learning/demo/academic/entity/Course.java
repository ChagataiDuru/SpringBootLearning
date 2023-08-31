package com.learning.demo.academic.entity;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.user.entity.Student;
import com.learning.demo.user.entity.Teacher;
import com.learning.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "course")
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String courseName;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instructor_id")
    private Teacher instructor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course",cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public Course(String courseName,User instructor) {
        this.courseName = courseName;
        this.instructor = (Teacher) instructor;
    }

/*    public void setStudents(List<User> all) {
        for(User u: all){
            this.students.add((Student) u);
            ((Student)u).setCourse(this);
        }
    }*/
}
