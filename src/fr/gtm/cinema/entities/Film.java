package fr.gtm.cinema.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="films")
@NamedQueries({
	@NamedQuery(name = "Film.getAll", query = "SELECT f FROM Film f")})
public class Film {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_film")
private long id;

private String titre;

private String realisateur;

@Column(name ="date_sortie")
private LocalDate dateSortie;

@Column(name="prixht")
private double prixHT;

private int duree;//durée du film en minutes

@ManyToMany(mappedBy="films", fetch=FetchType.EAGER)
//@Transient
private List<Acteur> acteurs = new ArrayList<Acteur>();

@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name="film_acteur",joinColumns = @JoinColumn(name="fk_film"), inverseJoinColumns =@ JoinColumn(name="fk_acteur"))
@MapKeyColumn(name = "role")
private Map<String, Acteur> role = new HashMap<String, Acteur>();

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getRealisateur() {
	return realisateur;
}

public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
}

public LocalDate getDateSortie() {
	return dateSortie;
}

public void setDateSortie(LocalDate dateSortie) {
	this.dateSortie = dateSortie;
}

public int getDuree() {
	return duree;
}

public void setDuree(int duree) {
	this.duree = duree;
}

public List<Acteur> getActeurs() {
	return acteurs;
}

public void setActeurs(List<Acteur> acteurs) {
	this.acteurs = acteurs;
}

public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public double getPrixHT() {
	return prixHT;
}

public void setPrixHT(double prixHT) {
	this.prixHT = prixHT;
}

@Override
public String toString() {
	return "Film: "+ titre + ", réalisé par: " + realisateur + ", sortie le: " + dateSortie
			+ ", d'une durée de: " + duree + " minutes, avec les acteurs suivants: " + acteurs;
}

public Map<String, Acteur> getRole() {
	return role;
}

public void setRole(Map<String, Acteur> role) {
	this.role = role;
}

//Map entre un rôle et un acteur
//@Transient
//private Map<String, Acteur> roles = new HashMap<String, Acteur>();



}
