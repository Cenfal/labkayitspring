package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "mydb")
public class RoleEntity {
    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;
    @Basic
    @Column(name = "DELETE", nullable = true)
    private Byte delete;
    @Basic
    @Column(name = "CREATE", nullable = true)
    private Byte create;
    @Basic
    @Column(name = "UPDATE", nullable = true)
    private Byte update;
    @Basic
    @Column(name = "READ", nullable = true)
    private Byte read;



}
