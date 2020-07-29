package io.la.pieza.ws;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import io.la.pieza.service.pago.common.ConstantesPagos;
import io.la.pieza.service.pago.response.GasolinerasClienteResponse;
import io.la.pieza.service.pago.rest.ClientHelper;

public class TestClienteWSPagoGasolina {

	@Test
	public void test() {
		
		String jsonEntrada = "{"
				+"	\"email\" : \"info@srpago.com\", "
				+"	\"name\" : \"Juan\", "
				+"	\"lastName\" : \"Perez\", "
				+"	\"cardNumber\" : \"4242424242424242\", "
				+"	\"expirationDateYear\" : 2020, "
				+"	\"expirationDateMonth\" : 12, "
				+"	\"gasType\" :1, "
				+"	\"amount\" : 350.00, "
				+"	\"gasStation\" : \"209\", "
				+"	\"sellerName\" : \"Pedro Perez\" "
				+"}";

		Client cliente = ClientHelper.createClient();
		String jsonResp = "";
		GasolinerasClienteResponse voResp = null;

		try {

			WebResource service = cliente.resource(ConstantesPagos.URL_SERVICIO_PAGO_GASOLINA);
			jsonResp = service.path(ConstantesPagos.PATH_SERVICE_GASOLINA)
					.type("application/json")
					.header("Accept", MediaType.APPLICATION_JSON)
					.post(String.class, jsonEntrada);
			if(jsonResp != null && jsonResp.length() > 0) {
				//njsn = new String(jsonResp.getBytes(ConstantesPagos.ISO_8859_1));
				ObjectMapper objectMapper = new ObjectMapper();
				voResp = objectMapper.readValue(jsonResp, GasolinerasClienteResponse.class);
				System.out.println("Respuesta cliente: \n"+ voResp.toString());
			}else {
				System.out.println("no regreso respuesta el cliente");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
