package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import domain.Residence;

@Entity
public class Personne {


	private int id;
	private String nom;
	private String prenom;
	private int age;
	private Collection<Personne> amis;
	private Collection<ElectronicDevice> ElectronicDevices;
	private Collection<Residence> maisons;

	public Personne() {
		this.maisons = new ArrayList<Residence>();
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@JsonIgnore
	@ManyToMany
	public Collection<Personne> getAmis() {
		return amis;
	}

	public void setAmis(Collection<Personne> amis) {
		this.amis = amis;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprio", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getElectronicDevices() {
		return ElectronicDevices;
	}

	public void setElectronicDevices(Collection<ElectronicDevice> ElectronicDevices) {
		this.ElectronicDevices = ElectronicDevices;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprio", cascade = CascadeType.PERSIST)
	public Collection<Residence> getMaisons() {
		return maisons;
	}

	public void setMaisons(Collection<Residence> maisons) {
		this.maisons = maisons;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
