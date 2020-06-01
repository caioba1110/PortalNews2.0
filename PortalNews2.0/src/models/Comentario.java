package models;

public class Comentario implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String nome;
	String texto;
	int noticiaId;
	
	public Comentario() {
		
	}
	
	public Comentario(String nome, String texto, int noticiaId) {
		super();
		this.nome = nome;
		this.texto = texto;
		this.noticiaId = noticiaId;
	}



	public Comentario(int id, String nome, String texto, int noticiaId) {
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.noticiaId = noticiaId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getNoticiaId() {
		return noticiaId;
	}
	public void setNoticiaId(int noticia_id) {
		this.noticiaId = noticia_id;
	}
	
	
}
