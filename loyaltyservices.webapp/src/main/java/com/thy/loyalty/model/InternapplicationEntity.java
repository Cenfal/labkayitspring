package com.lab.weblab.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "internapplication", schema = "mydb")
public class InternapplicationEntity {
    @Id
    @Column(name = "INTERNAPPLICATION_ID", nullable = false)
    private Integer internapplicationId;
    @Basic
    @Column(name = "STUDENT_ID", nullable = true)
    private Integer studentId;
    @Basic
    @Column(name = "STUDENTIDENTITY_ID", nullable = true)
    private Integer studentidentityId;
    @Basic
    @Column(name = "STATUS_ID", nullable = true)
    private Integer statusId;
    @Basic
    @Column(name = "HEALTHINSURANCESTATUS_ID", nullable = true)
    private Integer healthinsurancestatusId;
    @Basic
    @Column(name = "APPLICATIONRECEPIENT", nullable = true)
    private Integer applicationrecepient;
    @Basic
    @Column(name = "INTERNREPORTRECEPIENT", nullable = true)
    private Integer internreportrecepient;
    @Basic
    @Column(name = "INTERNSHIPTYPE", nullable = true, length = 10)
    private String internshiptype;
    @Basic
    @Column(name = "INTERNSHIPSTARTINGDATE", nullable = true)
    private Date internshipstartingdate;
    @Basic
    @Column(name = "INTERSHIPFINISHINGDATE", nullable = true)
    private Date intershipfinishingdate;
    @Basic
    @Column(name = "WORKDAYS", nullable = true)
    private Integer workdays;
    @Basic
    @Column(name = "WORKDAYSCONFIRMED", nullable = true)
    private Integer workdaysconfirmed;
    @Basic
    @Column(name = "ENTITYFORINTERNSHIP", nullable = true, length = 150)
    private String entityforinternship;
    @Basic
    @Column(name = "STUDENTGRADE", nullable = true)
    private Integer studentgrade;

}
