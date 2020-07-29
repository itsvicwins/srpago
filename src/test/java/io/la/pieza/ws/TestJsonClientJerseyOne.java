package io.la.pieza.ws;

import org.junit.Test;
import io.la.pieza.service.pago.response.GasolinerasClienteResponse;
import io.la.pieza.service.pago.rest.ClienteGasolineraInfo;

public class TestJsonClientJerseyOne {
	
	@Test
	public void test() {
		
		GasolinerasClienteResponse resp = ClienteGasolineraInfo.ConsultaGasolineras();
		System.out.println("Respuesta servicio: \n"+resp.toString());
		
	}

}
