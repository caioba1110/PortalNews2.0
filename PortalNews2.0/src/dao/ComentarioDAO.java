package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Comentario;
import models.Noticia;

public class ComentarioDAO {
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " (nome, texto, fk_noticia_id) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getNoticiaId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
			
		}
	}
	public void alterar(Comentario comentario) {
		
		String alterar = "UPDATE comentario "
				+ "SET nome = ?, texto = ?"
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	public void excluir(int id) {
		
		String excluir = "DELETE FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, id);
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
		}
	}
	public Comentario consultar(int id) {
		
		String consultar = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentario c = new Comentario();
			if (resultado.next()) {
				c.setId(id);
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setNoticiaId(resultado.getInt("fk_noticia_id"));
			}
			return c;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

	public ArrayList<Comentario> listarComentarios(int noticiaId) {
		String consultar = "SELECT * FROM comentario "
				+ " WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, noticiaId);
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				lista.add(c);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}
	/*
	public ArrayList<Produto> listarProdutos() {
		
		String consultar = "SELECT * FROM produto";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Produto> lista = new ArrayList<>();
			while (resultado.next()) {
				Produto p = new Produto();
				p.setCodigo(resultado.getInt("codigo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setNome(resultado.getString("nome"));
				p.setValor(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}*/
}
