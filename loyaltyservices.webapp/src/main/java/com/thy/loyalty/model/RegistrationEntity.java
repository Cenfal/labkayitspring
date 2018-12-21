package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "registration", schema = "mydb")
public class RegistrationEntity {
    @Id
    @Column(name = "REGISTRATION_ID", nullable = false)
    private Integer registrationId;
    @Basic
    @Column(name = "GROUP_ID", nullable = true)
    private Integer groupId;
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;



}
