package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Noticia;
import service.NoticiaService;

public class AlterarNoticia implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
