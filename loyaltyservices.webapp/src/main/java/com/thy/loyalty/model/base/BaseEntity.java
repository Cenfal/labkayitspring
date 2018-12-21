package com.thy.loyalty.model.base;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
public abstract class BaseEntity implements Entity, Serializable
{
	@Version
	@Column(name = "Version", nullable = false)
	private Integer version;

	@Column(name = "CreateUser")
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", length = 23)
	private Date createDate;

	@Column(name = "UpdateUser")
	private String updateUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdateDate", length = 23)
	private Date updateDate;
}
