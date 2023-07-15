package it.softwaredoctor.chucknorris.controller;

import java.io.IOException;
import java.util.List;


import it.softwaredoctor.chucknorris.entity.Battuta;
import it.softwaredoctor.chucknorris.repository.BattutaRepository;
import it.softwaredoctor.chucknorris.repository.impl.BattutaRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listaBattuteServlet")
public class ListaBattuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BattutaRepository battutaRepository = new BattutaRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("q") != null) {
				String term = request.getParameter("q");
				List<Battuta> battute = battutaRepository.findByValueoOrUpdatedAt(term);
				request.setAttribute("battute", battute);
				request.getRequestDispatcher("listaRicerca.jsp").forward(request, response);
				return;
		}	
		List<Battuta> battute = battutaRepository.findAllOrderByDate();
		request.setAttribute("battute", battute);
		request.getRequestDispatcher("lista.jsp").forward(request, response);
	}
}
