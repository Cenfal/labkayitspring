package com.lab.weblab.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "instructor-email", schema = "mydb")
public class InstructorEmailEntity {
    @Basic
    @Column(name = "INSTRUCTOR_ID", nullable = true)
    private Integer instructorId;
    @Basic
    @Column(name = "EMAIL_ID", nullable = true)
    private Integer emailId;


}
