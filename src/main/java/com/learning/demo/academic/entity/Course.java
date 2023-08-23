package com.learning.demo.academic.entity;

import com.learning.demo.user.entity.Teacher;
import com.learning.demo.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "instructor_id", nullable = false)
    private Teacher instructor;


    public Course(String courseName,User instructor) {
        this.courseName = courseName;
        this.instructor = (Teacher) instructor;
    }

}
