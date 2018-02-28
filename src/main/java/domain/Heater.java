package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.Residence;

@Entity
public class Heater {
	private int id;
	private Residence maison;
	private float conso;

	

	public Heater(){
	}

	

	public float getConso() {
		return this.conso;
	}

	public void setConso(float conso) {
		this.conso = conso;
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public Residence getMaison() {
		return maison;
	}

	public void setMaison(Residence maison) {
		this.maison = maison;
	}
	
}
