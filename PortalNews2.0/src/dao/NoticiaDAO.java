package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Noticia;

import java.sql.ResultSet;

public class NoticiaDAO {
	
	private Connection conexao;
	
	public NoticiaDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}

	public void cadastrar(Noticia noticia) {
			
		String inserir = "INSERT INTO noticia "
				+ " (descricao, titulo, texto) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	public void alterar(Noticia noticia) {
		
		String alterar = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ?"
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			pst.setInt(4, noticia.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	public void excluir(int id) {
		
		String excluir = "DELETE FROM noticia "
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
	public Noticia consultar(int id) {
		
		String consultar = "SELECT * FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setId(id);
				n.setDescricao(resultado.getString("descricao"));
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
			}
			return n;
			
			
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
