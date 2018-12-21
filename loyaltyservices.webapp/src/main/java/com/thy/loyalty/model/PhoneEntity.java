package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phone", schema = "mydb")
public class PhoneEntity {
    @Id
    @Column(name = "PHONE_ID", nullable = false)
    private Integer phoneId;
    @Basic
    @Column(name = "PHONENUMBER", nullable = true)
    private Integer phonenumber;



}
