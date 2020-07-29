package io.la.pieza.service.pago.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.la.pieza.service.pago.common.ConstantesPagos;
import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.request.MessageInput;
import io.la.pieza.service.pago.response.CompraGasolinaResponse;
import io.la.pieza.service.pago.response.GasolinerasClienteResponse;
import io.la.pieza.service.pago.services.dao.IPagoCompraDao;
import io.la.pieza.service.pago.vo.DatosGasolinera;

@Component
@Path("/srpago")
public class WSPagos {
	
	@Autowired
	private IPagoCompraDao pagoGasolinaDAO;
		
	@POST
	@Path("/realizarPagoGasolina")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CompraGasolinaResponse realizaPagoGasolina(MessageInput entrada) {

		CompraGasolinaResponse response = null;
		
		if (entrada != null) {
			
			System.out.println(entrada.toString());
			
			GasolinerasClienteResponse resp = ClienteGasolineraInfo.ConsultaGasolineras(); 
			if(resp != null && resp.getResultadoConsulta().equalsIgnoreCase(ConstantesPagos.CONSULTA_CORRECTA)) {
				DatosGasolinera dato = findByGasStation(entrada.getGasStation(), resp.getListaEESSPrecio());
				
				Pago oay = entrada.convertToEntity(dato);
				pagoGasolinaDAO.save(oay);
				
				response = CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_TRANSACTION_SUCCESS, ConstantesPagos.ERR_TRANSACTION_SUCCESS);
			} else {
				if(resp == null)
					response = CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_CLIENTE_INCORRECTA, ConstantesPagos.ERR_COMUNICACION_CLIENTE);
				else
					response = CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_CLIENTE_INCORRECTA, resp.getResultadoConsulta());
			}
			
		} else {
			System.out.println(entrada);
			response = CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_ENTRADA_VACIA, ConstantesPagos.ERR_ENTRADA_VACIA);
		}
			
		return response;
	}

	private DatosGasolinera findByGasStation(String gasStation, List<DatosGasolinera> list) {
		List<DatosGasolinera> filtrada = list.stream().filter(d -> d.getIDPosteMaritimo().equalsIgnoreCase(gasStation)).collect(Collectors.toList());
		DatosGasolinera dato = null;
		if(filtrada.size() > 0)
			dato = filtrada.get(0);
	
		return dato;
	}
}
