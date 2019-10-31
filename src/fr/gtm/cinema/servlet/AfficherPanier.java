package fr.gtm.cinema.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Panier;


@WebServlet("/AfficherPanier")
public class AfficherPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private Panier p;   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/show-panier.jsp";
		List<FilmDTO> films = p.getFilms();
		int cnt = p.getCnt();
		p.prixTotalTTC(films);
		double tot = p.getPrixTotalTTC();
		request.setAttribute("films", films);
		request.setAttribute("cnt", cnt);
		request.setAttribute("tot", tot);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
