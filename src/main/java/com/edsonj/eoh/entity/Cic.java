package com.edsonj.eoh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6583684317342020725L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cic_id")
	private Long cicId;
	
	@Column(name = "cic_type")
	private String cicType;
	
	private String subject;
	private String body;
	
	@Column(name = "source_system")
	private String sourceSystem;
	
	@Column(name = "cic_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cicTimestamp; 
	
	@ManyToOne
	@JoinColumn(name="entity_id")
	private Party party;
	
	public Cic() {
		super();
	}
		
	public Cic(String cicType, String subject, String body, String sourceSystem, Date cicTimestamp) {
		super();
		this.cicType = cicType;
		this.subject = subject;
		this.body = body;
		this.sourceSystem = sourceSystem;
		this.cicTimestamp = cicTimestamp;
	}

	public Long getCicId() {
		return cicId;
	}
	public void setCicId(Long cicId) {
		this.cicId = cicId;
	}
	public String getCicType() {
		return cicType;
	}
	public void setCicType(String cicType) {
		this.cicType = cicType;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public Date getCicTimestamp() {
		return cicTimestamp;
	}
	public void setCicTimestamp(Date cicTimestamp) {
		this.cicTimestamp = cicTimestamp;
	}

	public Party getParty() {
		return party;
	}

	public void setEntity(Party party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Cic [cicId=" + cicId + ", cicType=" + cicType + ", subject=" + subject + ", body=" + body
				+ ", sourceSystem=" + sourceSystem + ", cicTimestamp=" + cicTimestamp + ", party=" + party + "]";
	}

}
