package it.softwaredoctor.chucknorris.controller;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import it.softwaredoctor.chucknorris.repository.*;
import it.softwaredoctor.chucknorris.repository.impl.*;
import it.softwaredoctor.chucknorris.entity.*;

@WebServlet("/contaParolaServlet")
public class ContaParolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BattutaRepository battutaRepository = new BattutaRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idBattuta"));
		Battuta battuta = battutaRepository.findById(id);
		if (battuta != null && battuta.getId() == id) {
			int countChuck = countParola(battuta);
			request.setAttribute("totaleParola", countChuck);
			request.setAttribute("joke", battuta.getValue());
			request.setAttribute("formattedDate", battuta.getUpdatedAt());
			request.getRequestDispatcher("random.jsp").forward(request, response);
		}
	}

	private int countParola(Battuta battuta) {
		int countChuck = 0;
		int cLettera = 0;
		int hLettera = 0;
		int uLettera = 0;
		int kLettera = 0;

		String battutaValue = battuta.getValue();
		if (battutaValue != null) {
			battutaValue = battutaValue.toLowerCase();
			char[] battutaChar = battutaValue.toCharArray();

			for (char carattere : battutaChar) {
				switch (carattere) {
				case 'c':
					cLettera++;
					break;
				case 'h':
					hLettera++;
					break;
				case 'u':
					uLettera++;
					break;
				case 'k':
					kLettera++;
					break;
				}
			}
			while (cLettera >= 2 && hLettera >= 1 && uLettera >= 1 && kLettera >= 1) {
				cLettera = cLettera - 2;
				hLettera--;
				uLettera--;
				kLettera--;
				countChuck++;
			}
		}
		return countChuck;
	}
}