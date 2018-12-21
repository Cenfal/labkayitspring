package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "mydb")
public class DepartmentEntity {
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    private Integer departmentId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    private String description;



}
