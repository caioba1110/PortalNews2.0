package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class CadastrarComentario
 */
@WebServlet(name = "CadastrarComentario.do", urlPatterns = { "/CadastrarComentario.do" })
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String texto = request.getParameter("comentario");
		
		HttpSession sessao = request.getSession();
		
		ComentarioService comentarioService = new ComentarioService();
		
		Comentario comentario = new Comentario(nome, texto, (int) sessao.getAttribute("id"));
		
		comentarioService.cadastrar(comentario);
		
		RequestDispatcher rd = request.getRequestDispatcher("ConsultarNoticia.do");
		rd.forward(request,response);
		//response.sendRedirect("ConsultarNoticia.do");
	}

}
