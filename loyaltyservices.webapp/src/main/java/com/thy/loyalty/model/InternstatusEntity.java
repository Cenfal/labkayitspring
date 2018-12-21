package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "internstatus", schema = "mydb")
public class InternstatusEntity {
    @Id
    @Column(name = "INTERNSTATUS_ID", nullable = false)
    private Integer internstatusId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 65)
    private String description;



}
