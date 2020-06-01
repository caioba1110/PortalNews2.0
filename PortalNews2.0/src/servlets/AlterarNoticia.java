package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class AlterarNoticia
 */
@WebServlet(name = "AlterarNoticia.do", urlPatterns = { "/AlterarNoticia.do" })
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_alterar"));
		String titulo = request.getParameter("titulo_alterar");
		String noticia = request.getParameter("noticia_alterar");
		String descricao = request.getParameter("descricao_alterar");
		
		Noticia n = new Noticia(id, titulo, noticia, descricao);
		
		NoticiaService noticiaService = new NoticiaService();
		
		String alerta = noticiaService.alterar(n);
		
		PrintWriter saida = response.getWriter();
		
		saida.println(alerta);
	}

}
