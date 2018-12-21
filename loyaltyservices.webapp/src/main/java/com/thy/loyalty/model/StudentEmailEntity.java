package com.lab.weblab.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "student-email", schema = "mydb")
public class StudentEmailEntity {
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "EMAIL_ID", nullable = true)
    private Integer emailId;



}
