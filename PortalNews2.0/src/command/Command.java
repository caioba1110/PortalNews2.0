package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Interface respons�vel por definir a estrutura
 * dos comandos existentes na aplica��o
 */
public interface Command {
	
	/**
	 * M�todo respons�vel por executar a a��o de cada comando.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void executar(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException;
	
}