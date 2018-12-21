package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructor-role", schema = "mydb")
public class InstructorRoleEntity {
    @Id
    @Column(name = "INSTRUCTOR-ROLE_ID", nullable = false)
    private Integer instructorRoleId;
    @Basic
    @Column(name = "ROLE_ID", nullable = true)
    private Integer roleId;
    @Basic
    @Column(name = "INSTRUCTOR_ID", nullable = true)
    private Integer instructorId;
    @Basic
    @Column(name = "EVENT_ID", nullable = true)
    private Integer eventId;


}
