package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Comentario;
import models.Noticia;
import service.ComentarioService;
import service.NoticiaService;

public class ConsultarNoticia implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		int id = Integer.parseInt(request.getParameter("id_consultar"));
		
		if (sessao.getAttribute("id") == null ) {
			id = Integer.parseInt(request.getParameter("id_consultar"));
		}
		else if(id != (int) sessao.getAttribute("id")) {
			id = Integer.parseInt(request.getParameter("id_consultar"));
		}
		else {
			id = (int) sessao.getAttribute("id");
		}
		
		sessao.setAttribute("id", id);
		
		NoticiaService noticia = new NoticiaService();
		
		Noticia n = noticia.consultar(id);
		
		ComentarioService comentarioService = new ComentarioService();
		
		ArrayList<Comentario> lista = new ArrayList<>();
		
		lista = comentarioService.consultarTodos(id);
		
		PrintWriter saida = response.getWriter();
		
		sessao.setAttribute("noticia", n);
		sessao.setAttribute("lista", lista);
		
		response.sendRedirect("consultarComentarios.jsp");
		
	}

}
