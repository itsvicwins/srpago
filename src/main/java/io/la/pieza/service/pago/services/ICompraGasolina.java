package io.la.pieza.service.pago.services;

import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.response.CompraGasolinaResponse;

public interface ICompraGasolina {

	public CompraGasolinaResponse addPago(Pago pag);
	
}
