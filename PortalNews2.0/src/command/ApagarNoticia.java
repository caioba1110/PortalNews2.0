package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;

public class ApagarNoticia implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_apagar"));
		
		NoticiaService noticiaService = new NoticiaService();
		
		String alerta = noticiaService.apagar(id);
		
		PrintWriter saida = response.getWriter();
		
		saida.println(alerta);
		
	}

}
