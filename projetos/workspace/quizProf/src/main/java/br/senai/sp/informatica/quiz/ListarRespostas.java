package br.senai.sp.informatica.quiz;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import br.senai.sp.informatica.quiz.lib.Template;
import br.senai.sp.informatica.quiz.lib.WebUtilities;


@SuppressWarnings("serial")
@WebServlet("/listarRespostas")
public class ListarRespostas extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// Lê todos os cookies da requisição Web
		String ate18 = WebUtilities.getCookieValue(req, "ate18", "0");
		String ate26 = WebUtilities.getCookieValue(req, "ate26", "0");
		String ate35 = WebUtilities.getCookieValue(req, "ate35", "0");
		String ate99 = WebUtilities.getCookieValue(req, "ate99", "0");
		
		// Configurar o Thymeleaf
		resp.setCharacterEncoding("UTF-8");
		ServletContext ctx = req.getServletContext();
		TemplateEngine engine = Template.getEngine(ctx);
		WebContext webContext = new WebContext(req, resp, ctx);
		
		// passa os parâmetros para o Thymeleaf
		webContext.setVariable("ate18", ate18);
		webContext.setVariable("ate26", ate26);
		webContext.setVariable("ate35", ate35);
		webContext.setVariable("ate99", ate99);
		
		// solicita ao engine do Thymeleaf montar e enviar a pagina html
		engine.process("listaResposta", webContext, resp.getWriter());
	}
}
