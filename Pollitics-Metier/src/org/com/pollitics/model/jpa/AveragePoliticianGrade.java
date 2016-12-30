package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the average_politician_grade database table.
 * 
 */
@Entity
@Table(name="average_politician_grade")
@NamedQuery(name="AveragePoliticianGrade.findAll", query="SELECT a FROM AveragePoliticianGrade a")
public class AveragePoliticianGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AVERAGE_POLITICIAN_GRADE")
	private int idAveragePoliticianGrade;

	@Column(name="UPDATED_DATE")
	private Timestamp updatedDate;

	private float value;

	//bi-directional many-to-one association to Politician
	@ManyToOne
	@JoinColumn(name="ID_POLITICIAN")
	private Politician politician;

	public AveragePoliticianGrade() {
	}

	public int getIdAveragePoliticianGrade() {
		return this.idAveragePoliticianGrade;
	}

	public void setIdAveragePoliticianGrade(int idAveragePoliticianGrade) {
		this.idAveragePoliticianGrade = idAveragePoliticianGrade;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Politician getPolitician() {
		return this.politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	}

}