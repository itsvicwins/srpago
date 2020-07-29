package io.la.pieza.service.pago.services;

import org.springframework.beans.factory.annotation.Autowired;

import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.response.CompraGasolinaResponse;
import io.la.pieza.service.pago.services.dao.IPagoCompraDao;


public class CompraGasolinaService implements ICompraGasolina{

	@Autowired(required=true)
	IPagoCompraDao pagoDAO;
	
	@Override
	public CompraGasolinaResponse addPago(Pago pag) {
		return pagoDAO.save(pag);
	}
}
