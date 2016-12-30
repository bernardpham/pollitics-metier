package org.com.pollitics.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
@Table(name="politician_grade")
public class PoliticianGrade {

	@EmbeddedId
	private PoliticianGradeID primaryKey;
	
	@ManyToOne
	@MapsId("politicianID")
	@JoinColumn(name="ID_POLITICIAN")
	private Politician politician;
	
	@ManyToOne
	@MapsId("userID")
	@JoinColumn(name="ID_USER")
	private User user;

	
	@Column(name="VALUE")
	private BigDecimal politicianGradeValue;
	
//	@Temporal(TemporalType.DATE)
//	@Column(name="CREATION_DATE")
	@Transient
	private Date creationDate;

	public BigDecimal getPoliticianGradeValue() {
		return politicianGradeValue;
	}

	public void setPoliticianGradeValue(BigDecimal politicianGradeValue) {
		this.politicianGradeValue = politicianGradeValue;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public PoliticianGradeID getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(PoliticianGradeID primaryKey) {
		this.primaryKey = primaryKey;
	}
	
}
