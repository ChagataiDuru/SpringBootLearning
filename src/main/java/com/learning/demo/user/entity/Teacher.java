package com.learning.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Teacher")
@Data
@Table(name = "teacher")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {

    @Column(name = "orgId")
    int orgId;

    public Teacher(String firstName, String lastName, String mail,int orgId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.orgId = orgId;
    }
}
