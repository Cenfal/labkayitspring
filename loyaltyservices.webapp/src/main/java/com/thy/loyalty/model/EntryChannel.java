package com.thy.loyalty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by INNGKISAKOL on 2/9/2018.
 */
@Data
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "ENTRY_CHANNEL")
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true, callSuper = true, of = {"id"})
public class EntryChannel implements Serializable
{
    @Id
    private String id;

    @Column(name = "first_channel")
    private String firstChannel;

    @Column(name = "second_channel")
    private String secondChannel;

    @Column(name = "third_channel")
    private String thirdChannel;

    @Column(name = "description")
    private String description;
}
