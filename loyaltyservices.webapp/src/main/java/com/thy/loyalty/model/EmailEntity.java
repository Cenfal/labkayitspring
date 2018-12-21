package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "email", schema = "mydb")
public class EmailEntity {
    @Id
    @Column(name = "EMAIL_ID", nullable = false)
    private Integer emailId;
    @Basic
    @Column(name = "EMAILADDRESS", nullable = true, length = 60)
    private String emailaddress;



}
