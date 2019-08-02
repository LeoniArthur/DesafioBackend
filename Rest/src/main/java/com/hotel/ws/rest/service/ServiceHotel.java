package com.hotel.ws.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hotel.ws.rest.vo.Hotel;
import com.hotel.ws.rest.vo.VOHospede;

@Path("/Checkin")
public class ServiceHotel {

	@POST
	@Path("/createCheckin")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String createHospede(Hotel ho) {
		
		HotelDAO h = new HotelDAO();
		return h.createCheckin(ho);
	}

	@POST
	@Path("/calculo")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public float calculo(Hotel ho) {
		
		HotelDAO h = new HotelDAO();
		return h.calculo(ho);
	}

	@POST
	@Path("/historicoHotel")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Hotel> historicoHotel() {
	
		HotelDAO h = new HotelDAO();
		return h.historicoHotel();
	}

	@POST
	@Path("/atuaisHotel")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Hotel> atuaisHotel() {
		
		HotelDAO h = new HotelDAO();
		return h.atuaisHotel();
	}

}
