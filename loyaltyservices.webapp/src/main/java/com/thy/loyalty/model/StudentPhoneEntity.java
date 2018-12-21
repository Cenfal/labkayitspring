package com.lab.weblab.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "student-phone", schema = "mydb")
public class StudentPhoneEntity {
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "PHONE_ID", nullable = true)
    private Integer phoneId;


}