package com.learning.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @Getter(AccessLevel.NONE)
    private String lastName;

    @Column(name = "email")
    private String email;

}
