package com.hotel.ws.rest.vo;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

public class Hotel extends VOHospede {

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Boolean getAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}

	public Timestamp dataEntrada;
	public Timestamp dataSaida;
	public Boolean adicionalVeiculo;

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float preco;

	public static float calculo(Timestamp dataEntrada, Timestamp dataSaida) {

		if (dataEntrada == null || dataSaida == null) {
			return 0;
		}

		int days = (int) ((dataSaida.getTime() - dataEntrada.getTime()) / (24 * 60 * 60 * 1000));

		return (days > 0 ? days : 0);

	}

	@SuppressWarnings("deprecation")
	public int getWorkingDays(Timestamp dataEntrada, Timestamp dataSaida) {

		int workingDays = 0;
		int totalDays = (int) calculo(dataEntrada, dataSaida);

	
		Calendar calendar = new GregorianCalendar(dataSaida.getYear(), dataSaida.getMonth(), dataSaida.getDay());

		for (int i = 0; i <= totalDays; i++) {

			if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					&& !(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				workingDays++;
			}
			calendar.add(Calendar.DATE, 1);
		}

		return workingDays;
	}

	public float getPrice(Timestamp dataEntrada, Timestamp dataSaida, Boolean carro) {
		float preco = 0;
		float diasTotais = calculo(dataEntrada, dataSaida);
		float diasUteis = getWorkingDays(dataEntrada, dataSaida);
		float finaisSemana = diasTotais - diasUteis;

		if (finaisSemana > 0) {
			preco = finaisSemana * 150;
			if (carro = true) {
				preco = preco + finaisSemana * 20;
			}
		}
		if (diasUteis > 0) {
			preco = preco + (diasUteis * 120);
			if (carro = true) {
				preco = preco + diasUteis * 15;
			}
		}

		return preco;
	}

}
