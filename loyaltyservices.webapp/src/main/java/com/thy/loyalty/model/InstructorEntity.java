package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructor", schema = "mydb")
public class InstructorEntity {
    @Id
    @Column(name = "INSTRUCTOR_ID", nullable = false)
    private Integer instructorId;
    @Basic
    @Column(name = "USERNAME", nullable = true, length = 45)
    private String username;
    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 45)
    private String password;
    @Basic
    @Column(name = "NAME", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "SURNAME", nullable = true, length = 30)
    private String surname;
    @Basic
    @Column(name = "TITLE", nullable = true, length = 25)
    private String title;
    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = true)
    private Integer departmentId;


}
