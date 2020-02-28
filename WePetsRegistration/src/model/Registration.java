package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OWNER_ID")
	private int id;
	@Column(name="OWNER_NAME")
	private String rigidtionName;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String rigidtionName) {
		super();
		this.rigidtionName = rigidtionName;
	}

	public Registration(int id, String rigidtionName) {
		super();
		this.id = id;
		this.rigidtionName = rigidtionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrigidtionName() {
		return rigidtionName;
	}

	public void setrigidtionName(String rigidtionName) {
		this.rigidtionName = rigidtionName;
	}

	@Override
	public String toString() {
		return "Shopper [id=" + id + ", rigidtionName=" + rigidtionName + "]";
	}
}
