package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "mydb")
public class AddressEntity {
    @Id
    @Column(name = "ADDRESS_ID", nullable = false)
    private Integer addressId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 300)
    private String description;



}
