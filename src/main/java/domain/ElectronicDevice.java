package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.Residence;

@Entity
public class ElectronicDevice {
	private int id;
	private String nom;
	private Personne proprio;
	private float conso;
	
	public ElectronicDevice(){
	}
	

	
	public float getConso() {
		return conso;
	}


	public void setConso(float conso) {
		this.conso = conso;
	}



	public ElectronicDevice(String nom, float conso,Personne proprio) {
		this.nom = nom;
		this.proprio = proprio;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public Personne getProprio() {
		return proprio;
	}

	public void setProprio(Personne proprio) {
		this.proprio = proprio;
	}
}
