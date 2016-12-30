package org.com.pollitics.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
@Table(name="average_politician_grade")
public class AveragePoliticianGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_AVERAGE_POLITICIAN_GRADE")
	private long idAveragePoliticianGrade;

	@Column(name="VALUE")
	private BigDecimal averagePoliticianGradeValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DATE")
	private Date updateDate;

	public long getIdAveragePoliticianGrade() {
		return idAveragePoliticianGrade;
	}

	public void setIdAveragePoliticianGrade(long idAveragePoliticianGrade) {
		this.idAveragePoliticianGrade = idAveragePoliticianGrade;
	}

	public BigDecimal getAveragePoliticianGradeValue() {
		return averagePoliticianGradeValue;
	}

	public void setAveragePoliticianGradeValue(BigDecimal averagePoliticianGradeValue) {
		this.averagePoliticianGradeValue = averagePoliticianGradeValue;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
