package fr.gtm.cinema.services;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import fr.gtm.cinema.dao.FilmDAO;
import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Film;

@Singleton
public class CinemaService {
	@EJB private FilmDAO dao;
	
	public List<Film> getAllFilms(){
		return dao.getAllFilms();
	}

	public List<FilmDTO> getAllFilmsDTO() {

		return dao.getAllFilmsDTO();
	}
	
	public Film findFilmById(long id) {
		return dao.findFilmById(id);
	}
}