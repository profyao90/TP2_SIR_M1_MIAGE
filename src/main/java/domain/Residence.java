package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import domain.ElectronicDevice;
import domain.Personne;

@Entity
public class Residence {
	private int id;
	private String adresse;
	private Collection<Heater> chauffages;
	private float taille;
	private int nbPieces;
	private Personne proprio;

	public Residence() {

	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="maison", cascade = CascadeType.PERSIST)
	public Collection<Heater> getChauffages() {
		return chauffages;
	}

	public void setChauffages(Collection<Heater> chauffages) {
		this.chauffages = chauffages;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
	@ManyToOne
	public Personne getProprio() {
		return proprio;
	}

	public void setProprio(Personne proprio) {
		this.proprio = proprio;
	}


}
