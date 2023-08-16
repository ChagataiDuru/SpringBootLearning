package com.learning.demo.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table()
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Setter(AccessLevel.NONE)
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    @Getter(AccessLevel.NONE)
    String lastName;

    @Column(name = "email")
    String email;
}
