package it.softwaredoctor.chucknorris.entity;


import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "battuta")
public class Battuta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "value", length = 3000, nullable = false)
	private String value;

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Battuta [id=" + id + ", value=" + value + ", updatedAt=" + updatedAt + "]";
	}

	

}
