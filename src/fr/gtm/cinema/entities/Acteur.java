package fr.gtm.cinema.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="acteurs")
public class Acteur {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_acteur")
private long id;

private String civilite;

private String nom;

private String prenom;

@Column(name="date_naissance")
private LocalDate dateNaissace;

@Column(name="date_deces")
private LocalDate dateMort;

@ManyToMany(fetch=FetchType.EAGER)
@JoinTable(name="film_acteur", joinColumns=@JoinColumn(name="fk_film"), inverseJoinColumns=@JoinColumn(name="fk_acteur"))
private List<Film> films;

public String getCivilite() {
	return civilite;
}

public void setCivilite(String civilite) {
	this.civilite = civilite;
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

public LocalDate getDateNaissace() {
	return dateNaissace;
}

public void setDateNaissace(LocalDate dateNaissace) {
	this.dateNaissace = dateNaissace;
}

public LocalDate getDateMort() {
	return dateMort;
}

public void setDateMort(LocalDate dateMort) {
	this.dateMort = dateMort;
}

public List<Film> getFilms() {
	return films;
}

public void setFilms(List<Film> films) {
	this.films = films;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

@Override
public String toString() {
	return prenom + " " + nom;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
	result = prime * result + ((dateMort == null) ? 0 : dateMort.hashCode());
	result = prime * result + ((dateNaissace == null) ? 0 : dateNaissace.hashCode());
	result = prime * result + ((films == null) ? 0 : films.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Acteur other = (Acteur) obj;
	if (civilite == null) {
		if (other.civilite != null)
			return false;
	} else if (!civilite.equals(other.civilite))
		return false;
	if (dateMort == null) {
		if (other.dateMort != null)
			return false;
	} else if (!dateMort.equals(other.dateMort))
		return false;
	if (dateNaissace == null) {
		if (other.dateNaissace != null)
			return false;
	} else if (!dateNaissace.equals(other.dateNaissace))
		return false;
	if (films == null) {
		if (other.films != null)
			return false;
	} else if (!films.equals(other.films))
		return false;
	if (id != other.id)
		return false;
	if (nom == null) {
		if (other.nom != null)
			return false;
	} else if (!nom.equals(other.nom))
		return false;
	if (prenom == null) {
		if (other.prenom != null)
			return false;
	} else if (!prenom.equals(other.prenom))
		return false;
	return true;
}



}
