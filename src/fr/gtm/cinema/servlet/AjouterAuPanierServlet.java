package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Panier;
import fr.gtm.cinema.services.CinemaService;


@WebServlet("/AjouterAuPanierServlet")
public class AjouterAuPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject private Panier p;   
    @Inject private CinemaService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/FilmsServlet";
		
		long id = Long.valueOf(request.getParameter("id"));
		FilmDTO f = new FilmDTO(service.findFilmById(id));
		p.addFilmDTO(f);
		List<FilmDTO> films = p.getFilms();
		request.setAttribute("films", films);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
