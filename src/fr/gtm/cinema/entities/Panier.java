package fr.gtm.cinema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import fr.gtm.cinema.dto.FilmDTO;

@SessionScoped
public class Panier implements Serializable {
private double prixTotalTTC;
private List<FilmDTO> films = new ArrayList<FilmDTO>();
private int cnt = 0;

public Panier() {}

public void addFilmDTO(FilmDTO f) {
	films.add(f);
	cnt = cnt+1;
}

public void removeFilmDTO(FilmDTO f) {
	films.remove(f);
	cnt = cnt-1;
}

public double prixTotalTTC(List<FilmDTO> f) {
	prixTotalTTC = 0;
	for(FilmDTO film : f) {
		prixTotalTTC = prixTotalTTC + film.getPrixHT() + (film.getPrixHT()/10);
	}
	
	return prixTotalTTC;
	
}

public double getPrixTotalTTC() {
	return prixTotalTTC;
}

public void setPrixTotalTTC(double prixTotalTTC) {
	this.prixTotalTTC = prixTotalTTC;
}

public List<FilmDTO> getFilms() {
	return films;
}

public void setFilms(List<FilmDTO> films) {
	this.films = films;
}

public int getCnt() {
	return cnt;
}

public void setCnt(int cnt) {
	this.cnt = cnt;
}



}
