package fr.gtm.cinema.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Film;

@Singleton
public class FilmDAO {
@PersistenceContext(name="cinema") private EntityManager em;	


	public List<Film> getAllFilms(){
		return em.createNamedQuery("Film.getAll",Film.class).getResultList();
	}
	
	public void creerFilm(Film f) {
		em.persist(f);
	}
	
	public Film findFilmById(long id) {
		Film f = em.find(Film.class, id);		
		return f;
	}
	
	public void deleteFilm(long id) {
		Film f = em.find(Film.class, id);
		em.remove(f);
	}
	
	public void updateFilm(Film f) {
		em.merge(f);
	}
	
	public List<FilmDTO> getAllFilmsDTO() {
		List<Film> filmsPasDTO = getAllFilms();
		List<FilmDTO> films = new ArrayList<FilmDTO>();
		
		for(Film f : filmsPasDTO) {
			FilmDTO a = new FilmDTO(f);
			films.add(a);
		}
		
		return films;
	}
}
