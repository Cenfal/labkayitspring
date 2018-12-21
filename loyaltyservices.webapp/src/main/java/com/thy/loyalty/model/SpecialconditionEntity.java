package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "specialcondition", schema = "mydb")
public class SpecialconditionEntity {
    @Id
    @Column(name = "SPECIALCONDITIONS_ID", nullable = false)
    private Integer specialconditionsId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    private String description;



}
