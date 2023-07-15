package it.softwaredoctor.chucknorris.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import it.softwaredoctor.chucknorris.repository.BattutaRepository;
import it.softwaredoctor.chucknorris.repository.impl.BattutaRepositoryImpl;
import it.softwaredoctor.chucknorris.entity.*;

@WebServlet("/battutaServlet")
public class BattutaServlet<battutaR> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BattutaRepository battutaRepository = new BattutaRepositoryImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		URL url = new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		connection.setRequestProperty("Accept", "application/json"); 
		connection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String responseString = reader.readLine();
		System.out.println(responseString);
		reader.close();
		JSONObject jsonObject = new JSONObject(responseString.toString());
		Battuta battuta = new Battuta();
		String joke = jsonObject.getString("value");
		String updatedAtString = jsonObject.getString("updated_at");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date updatedAt = null;
		String formattedDate = null; 
		try {
			updatedAt = dateFormat.parse(updatedAtString);
			formattedDate = dateFormat.format(updatedAt);
			System.out.println("Updated at: " + formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		battuta.setValue(joke);
		battuta.setUpdatedAt(updatedAt);
		battutaRepository.save(battuta);
		request.setAttribute("battuta", battuta); 
		request.setAttribute("joke", joke);
		request.setAttribute("formattedDate", formattedDate);
		request.getRequestDispatcher("random.jsp").forward(request, response);
		connection.disconnect();
		return;
	}
}
