package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;

/**
 * Servlet implementation class ApagarNoticia
 */
@WebServlet(name = "ApagarNoticia.do", urlPatterns = { "/ApagarNoticia.do" })
public class ApagarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_apagar"));
		
		NoticiaService noticiaService = new NoticiaService();
		
		String alerta = noticiaService.apagar(id);
		
		PrintWriter saida = response.getWriter();
		
		saida.println(alerta);
	}

}
