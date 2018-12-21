package com.lab.weblab.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "mydb")
public class EventEntity {
    @Id
    @Column(name = "EVENT_ID", nullable = false)
    private Integer eventId;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 150)
    private String description;
    @Basic
    @Column(name = "GROUPS", nullable = true)
    private Integer groups;
    @Basic
    @Column(name = "INSTRUCTOR_ID", nullable = true)
    private Integer instructorId;



}
