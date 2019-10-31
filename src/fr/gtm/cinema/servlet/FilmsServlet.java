package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Film;
import fr.gtm.cinema.entities.Panier;
import fr.gtm.cinema.services.CinemaService;




@WebServlet("/FilmsServlet")
public class FilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CinemaService service;
	@Inject private Panier p;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = "/show-films.jsp";
		
//		List<Film> films = service.getAllFilms();
		List<FilmDTO> films = service.getAllFilmsDTO(); 
		int cnt = p.getCnt();
		
		request.setAttribute("films", films);
		request.setAttribute("cnt", cnt);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
