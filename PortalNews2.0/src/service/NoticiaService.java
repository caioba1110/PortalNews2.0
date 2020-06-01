package service;

import dao.NoticiaDAO;
import models.Noticia;

public class NoticiaService {
	NoticiaDAO noticiaDAO = new NoticiaDAO();
	public String cadastro(Noticia noticia) {
		if(noticia.getDescricao().length() <= 512) {
			if(noticia.getTitulo().length() <= 126) {
				noticiaDAO.cadastrar(noticia);
				return "Cadastro feito com sucesso";
			}else {
				return "O titulo deve ter menos de 127 caracteres.";
			}
		}else {
			return "A descrição deve ter menos de 513 caracteres.";
		}
	}
	
	public String alterar(Noticia noticia) {
		if(noticia.getDescricao().length() <= 512) {
			if(noticia.getTitulo().length() <= 126) {
				noticiaDAO.alterar(noticia);
				return "Alteração feita com sucesso";
			}else {
				return "O titulo deve ter menos de 127 caracteres.";
			}
		}else {
			return "A descrição deve ter menos de 513 caracteres.";
		}
	}
	
	public String apagar(int id) {
		noticiaDAO.excluir(id);
		return "Apagado com sucesso";
	}
	
	public Noticia consultar(int id) {
		return noticiaDAO.consultar(id);
	}
}
