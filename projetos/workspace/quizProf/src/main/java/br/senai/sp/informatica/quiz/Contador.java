package br.senai.sp.informatica.quiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.quiz.lib.LongLivedCookie;
import br.senai.sp.informatica.quiz.lib.WebUtilities;

@SuppressWarnings("serial")
@WebServlet("/contador")
public class Contador extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String voto = req.getParameter("idade");
		
		if(voto == null) {
			resp.sendRedirect("paginaDeErro.html");
		} else {
			String valorDoCookie = WebUtilities.getCookieValue(req, voto, "0");
			int valor = Integer.parseInt(valorDoCookie) + 1;
			
			LongLivedCookie cookie = new LongLivedCookie(voto, String.valueOf(valor));
			resp.addCookie(cookie);
			
			resp.sendRedirect("paginaDeSucesso.html");
		}
	}
}
