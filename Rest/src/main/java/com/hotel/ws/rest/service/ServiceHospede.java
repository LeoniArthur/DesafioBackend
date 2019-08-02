package com.hotel.ws.rest.service;

import com.hotel.ws.rest.vo.VOHospede;
import com.hotel.ws.rest.service.Conexao;
import com.hotel.ws.rest.service.HospedeDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hospede")
public class ServiceHospede {

	@POST
	@Path("/createHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String createHospede(VOHospede vo) {

		HospedeDAO h = new HospedeDAO();
		return h.createHospede(vo);
	}

	@POST
	@Path("/readHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public VOHospede readHospede(VOHospede vo) {

		HospedeDAO h = new HospedeDAO();
		return h.readHospede(vo);
	}

	@POST
	@Path("/updateHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String updateHospede(VOHospede vo) {

		HospedeDAO h = new HospedeDAO();
		return h.updateHospede(vo);
	}

	@POST
	@Path("/deleteHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String deleteHospede(VOHospede vo) {

		HospedeDAO h = new HospedeDAO();
		return h.deleteHospede(vo);
	}

	@POST
	@Path("/listHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VOHospede> listHospede() {

		HospedeDAO h = new HospedeDAO();
		return h.listHospede();
	}

	@POST
	@Path("/searchHospede")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VOHospede> searchHospede(Util u) {
		System.out.println(u.getDado());
		HospedeDAO h = new HospedeDAO();
		return h.searchHospede(u.getCampo(), u.getDado());
	}

}