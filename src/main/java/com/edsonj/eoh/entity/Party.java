package com.edsonj.eoh.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="entity")
public class Party implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916546484450329437L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="entity_id")
	private Long entityId;
	
	@Column(name="entity_name")
	private String entityName;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@OneToMany(mappedBy="party")
	private List<Cic> cics;

	public Party() {
		super();
	}

	public Party(String entityName, String emailAddress) {
		super();
		this.entityName = entityName;
		this.emailAddress = emailAddress;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Cic> getCics() {
		return cics;
	}

	public void setCics(List<Cic> cics) {
		this.cics = cics;
	}

	@Override
	public String toString() {
		return "Party [entityId=" + entityId + ", entityName=" + entityName + ", emailAddress=" + emailAddress
				+ ", cics=" + cics + "]";
	}
	
	
}
