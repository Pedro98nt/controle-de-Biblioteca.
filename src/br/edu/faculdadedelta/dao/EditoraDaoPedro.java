package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.EditoraPedro;
import br.edu.faculdadedelta.util.Conexao;

public class EditoraDaoPedro {
	
	public void incluir(EditoraPedro editora) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "INSERT INTO editoras (desc_editora) VALUES(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		try {
			ps.setString(1, editora.getEditora().trim());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
		
	}
	
	public void alterar(EditoraPedro editora) throws Exception {
		Connection conn =Conexao.conectarNoBancoDeDados();
		String sql = "UPDATE editoras SET desc_editora=? WHERE id_editora=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		try {
			ps.setString(1, editora.getEditora().trim());
			ps.setLong(2, editora.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
		
	}

	public void excluir(EditoraPedro editora) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "DELETE FROM editoras WHERE id_editora=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		try {
			ps.setLong(1, editora.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
		
	}

	public List<EditoraPedro> listar() throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT * FROM editoras";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<EditoraPedro> listaRetorno = new ArrayList<>();
		
		try {
			while(rs.next()) {
				EditoraPedro editora = new EditoraPedro();
				editora.setId(rs.getLong("id_editora"));
				editora.setEditora(rs.getString("desc_editora").trim());
				listaRetorno.add(editora);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
		return listaRetorno;
	}

	public EditoraPedro pesquisarPorId(Long id) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT * FROM editoras WHERE id_editora = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		EditoraPedro retorno = new EditoraPedro();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				retorno.setId(rs.getLong("id_editora"));
				retorno.setEditora(rs.getString("desc_editora").trim());
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
		return retorno;
	}
}
