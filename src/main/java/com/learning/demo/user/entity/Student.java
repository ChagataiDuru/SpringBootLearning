package com.learning.demo.user.entity;

import com.learning.demo.academic.entity.Course;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity(name = "Student")
@DynamicUpdate
@Data
@Table(name = "student")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @Column(name = "student_id")
    String studentid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Student(String firstName, String lastName, String mail,String studentid) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.studentid = studentid;
        this.course = null;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
