package com.learning.demo.academic.entity;

import com.learning.demo.user.entity.Teacher;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "lesson")
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String lessonsName;

    @Column
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Teacher instructor;

}
