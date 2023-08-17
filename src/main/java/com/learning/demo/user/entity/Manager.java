package com.learning.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Manager")
@Data
@Table(name = "manager")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Manager extends User{

    @Column(name = "managerid")
    int managerid;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    Role role;

    public Manager(String firstName, String lastName, String mail,int managerid) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.managerid = managerid;
    }

}