package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "studentidentity", schema = "mydb")
public class StudentidentityEntity {
    @Id
    @Column(name = "STUDENTIDENTITY_ID", nullable = false)
    private Integer studentidentityId;
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "CITIZENNUMBER", nullable = true)
    private Integer citizennumber;
    @Basic
    @Column(name = "PLACEOFBIRTH", nullable = true, length = 45)
    private String placeofbirth;
    @Basic
    @Column(name = "DATEOFBIRTH", nullable = true, length = 45)
    private String dateofbirth;
    @Basic
    @Column(name = "MOTHERNAME", nullable = true, length = 45)
    private String mothername;
    @Basic
    @Column(name = "FATHERNAME", nullable = true, length = 45)
    private String fathername;






}
