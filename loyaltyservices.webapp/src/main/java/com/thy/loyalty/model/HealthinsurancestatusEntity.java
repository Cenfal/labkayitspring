package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "healthinsurancestatus", schema = "mydb")
public class HealthinsurancestatusEntity {
    @Id
    @Column(name = "HEALTHINSURANCESTATUS_ID", nullable = false)
    private Integer healthinsurancestatusId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 150)
    private String description;


}
