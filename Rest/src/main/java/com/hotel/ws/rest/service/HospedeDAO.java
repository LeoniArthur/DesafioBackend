package com.hotel.ws.rest.service;

import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.ws.rest.vo.VOHospede;
import com.hotel.ws.rest.service.Conexao;

public class HospedeDAO {

	// CREATE
	public String createHospede(VOHospede vo) {
		try {
			Connection connection = Conexao.getConexao();
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO hospedes(documento, nome, telefone) VALUES (?, ?, ?)");
			pstmt.setString(1, vo.getDocumento());
			pstmt.setString(2, vo.getNome());
			pstmt.setString(3, vo.getTelefone());
			pstmt.executeUpdate();
		} finally {
			return "Inserido!";
		}
	}

	// READ
	public VOHospede readHospede(VOHospede vo) {
		Connection connection = Conexao.getConexao();
		VOHospede retorno = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM hospedes where documento=?");

			pstmt.setString(1, vo.getDocumento());
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				retorno = new VOHospede();
				retorno.setDocumento(res.getString("documento"));
				retorno.setNome(res.getString("nome"));
				retorno.setTelefone(res.getString("telefone"));
			}

		} catch (SQLException ex) {

		}
		return retorno;
	}

	// UPDATE
	public String updateHospede(VOHospede vo) {
		Connection connection = Conexao.getConexao();
		String retorno = null;
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("UPDATE hospedes set nome=?,telefone=? where documento=?");
			pstmt.setString(1, vo.getNome());
			pstmt.setString(2, vo.getTelefone());
			pstmt.setString(3, vo.getDocumento());

			if (pstmt.executeUpdate() > 0) {
				retorno = "Alterado com sucesso!";
			} else {
				retorno = "Erro ao alterar";
			}

		} catch (SQLException ex) {

		}
		return retorno;
	}

	// DELETE
	public String deleteHospede(VOHospede vo) {
		Connection connection = Conexao.getConexao();
		String retorno = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM hospedes where documento=?");

			pstmt.setString(1, vo.getDocumento());

			if (pstmt.executeUpdate() > 0) {
				retorno = "Hospede excluido!";
			} else {
				retorno = "Erro ao excluir";
			}

		} catch (SQLException ex) {

		}
		return retorno;
	}

	// LIST
	public List<VOHospede> listHospede() {
		Connection connection = Conexao.getConexao();
		List<VOHospede> retorno = new ArrayList<VOHospede>();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM hospedes");

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				VOHospede item = new VOHospede();

				item.setDocumento(res.getString("documento"));
				item.setNome(res.getString("nome"));
				item.setTelefone(res.getString("telefone"));
				retorno.add(item);
			}

		} catch (SQLException ex) {
		}
		return retorno;
	}

	// searchHospede
	public List<VOHospede> searchHospede(String campo, String dado) {
		Connection connection = Conexao.getConexao();
		List<VOHospede> retorno = new ArrayList<VOHospede>();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM hospedes WHERE " + campo + " = ?");
			pstmt.setString(1, dado);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				VOHospede item = new VOHospede();

				item.setDocumento(res.getString("documento"));
				item.setNome(res.getString("nome"));
				item.setTelefone(res.getString("telefone"));
				retorno.add(item);
			}

		} catch (SQLException ex) {
		}
		return retorno;
	}

}
