package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import models.Comentario;

public class ComentarioService {
	
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	public ArrayList<Comentario> consultarTodos(int id) {
		return comentarioDAO.listarComentarios(id);
	}
	
	public void cadastrar (Comentario comentario) {
		if(comentario.getNome().length() < 126) {
			if(comentario.getTexto().length() < 512) {
				comentarioDAO.cadastrar(comentario);
			}
		}
	}
}
