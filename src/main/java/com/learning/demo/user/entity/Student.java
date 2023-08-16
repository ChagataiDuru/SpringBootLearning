package com.learning.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Student")
@Data
@Table(name = "student")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @Column(name = "studentid")
    String studentid;

    public Student(String firstName, String lastName, String mail,String studentid) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.studentid = studentid;
    }
}
