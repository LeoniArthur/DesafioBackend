package com.hotel.ws.rest.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.hotel.ws.rest.vo.Hotel;
import com.hotel.ws.rest.vo.VOHospede;

public class HotelDAO {

	// Checkin
	public String createCheckin(Hotel ho) {
		try {
			Connection connection = Conexao.getConexao();
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO hotel(\"documento\", \"nome\", \"telefone\", \"dataEntrada\", \"dataSaida\", \"adicionalVeiculo\") VALUES (?, ?, ?, ?, ?, ?)");

			pstmt.setString(1, ho.getDocumento());
			pstmt.setString(2, ho.getNome());
			pstmt.setString(3, ho.getTelefone());
			pstmt.setTimestamp(4, ho.getDataEntrada());
			pstmt.setTimestamp(5, ho.getDataSaida());
			pstmt.setBoolean(6, ho.getAdicionalVeiculo());
			System.out.println(pstmt);

			pstmt.executeUpdate();
		} catch (Exception e) {

			System.out.println("erro:" + e.getMessage());
			return "erro!";
		}
		return "inserido!";

	}

	// Historico
	public List<Hotel> historicoHotel() {
		Connection connection = Conexao.getConexao();
		List<Hotel> retorno = new ArrayList<Hotel>();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM hotel WHERE \"dataSaida\" <= CURRENT_TIMESTAMP");
			// pstmt.setString(1, dado);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				Hotel item = new Hotel();

				item.setDocumento(res.getString("documento"));
				item.setNome(res.getString("nome"));
				item.setTelefone(res.getString("telefone"));
				item.setDataEntrada(res.getTimestamp("dataEntrada"));
				item.setDataSaida(res.getTimestamp("dataSaida"));
				item.setAdicionalVeiculo(res.getBoolean("adicionalVeiculo"));
				item.setPreco(this.calculo(item));

				retorno.add(item);
			}

		} catch (SQLException e) {
			System.out.println("erro:" + e.getMessage());
		}
		return retorno;
	}

	// Atuais
	public List<Hotel> atuaisHotel() {
		Connection connection = Conexao.getConexao();
		List<Hotel> retorno = new ArrayList<Hotel>();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM hotel WHERE \"dataSaida\" >= CURRENT_TIMESTAMP");
			// pstmt.setString(1, dado);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				Hotel item = new Hotel();

				item.setDocumento(res.getString("documento"));
				item.setNome(res.getString("nome"));
				item.setTelefone(res.getString("telefone"));
				item.setDataEntrada(res.getTimestamp("dataEntrada"));
				item.setDataSaida(res.getTimestamp("dataSaida"));
				item.setAdicionalVeiculo(res.getBoolean("adicionalVeiculo"));
				item.setPreco(this.calculo(item));

				retorno.add(item);
			}

		} catch (SQLException e) {
			System.out.println("erro:" + e.getMessage());
		}
		return retorno;
	}

	// calculo
	public float calculo(Hotel ho) {

		return ho.getPrice(ho.getDataEntrada(), ho.getDataSaida(), ho.getAdicionalVeiculo());
	}

}
