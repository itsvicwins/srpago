package io.la.pieza.service.pago.services.dao;

import org.springframework.stereotype.Service;

import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.response.CompraGasolinaResponse;

@Service
public interface IPagoCompraDao {

	public CompraGasolinaResponse save(Pago pago);
	
}
