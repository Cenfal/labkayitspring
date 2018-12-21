package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student-role", schema = "mydb")
public class StudentRoleEntity {
    @Id
    @Column(name = "STUDENT-ROLE_ID", nullable = false)
    private Integer studentRoleId;
    @Basic
    @Column(name = "ROLE_ID", nullable = true)
    private Integer roleId;
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "EVENT_ID", nullable = true)
    private Integer eventId;


}


