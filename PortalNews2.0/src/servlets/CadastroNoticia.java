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
 * Servlet implementation class CadastroNoticia
 */
@WebServlet(name = "CadastroNoticia.do", urlPatterns = { "/CadastroNoticia.do" })
public class CadastroNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo_criar");
		String noticia = request.getParameter("noticia_criar");
		String descricao = request.getParameter("descricao_criar");
		
		NoticiaService noticiaService = new NoticiaService(); 
		
		Noticia n = new Noticia(descricao, titulo, noticia);
		
		String alerta = noticiaService.cadastro(n);
		
		PrintWriter saida = response.getWriter();
		
		saida.println(alerta);
		
	}
}
