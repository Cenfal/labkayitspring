package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group", schema = "mydb")
public class GroupEntity {
    @Id
    @Column(name = "GROUP_ID", nullable = false)
    private Integer groupId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 150)
    private String description;
    @Basic
    @Column(name = "TABLES", nullable = true)
    private Integer tables;
    @Basic
    @Column(name = "TABLEQUOTA", nullable = true)
    private Integer tablequota;
    @Basic
    @Column(name = "SPECIALCONDITION_ID", nullable = true)
    private Integer specialconditionId;
    @Basic
    @Column(name = "EVENT_ID", nullable = true)
    private Integer eventId;

}
