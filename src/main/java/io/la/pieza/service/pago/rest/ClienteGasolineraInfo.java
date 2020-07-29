package io.la.pieza.service.pago.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import io.la.pieza.service.pago.common.ConstantesPagos;
import io.la.pieza.service.pago.response.GasolinerasClienteResponse;

public class ClienteGasolineraInfo {


	/*
	public static GasolinerasClienteResponse ConsultaGasolineras(String numberStation) {

		GasolinerasClienteResponse respGas = null;
		Client client = null;
		try {
			client = JerseyHttpClientFactory.getJerseyHTTPSClient();
			Invocation.Builder invocationBuilder = client.target(ConstantesPagos.URL_SERVICIO_GASOLINERAS)
					.path(ConstantesPagos.PATH_SERVICE).
					request(MediaType.APPLICATION_JSON+ ConstantesPagos.CHARSET_UTF8);
			Response resp   = invocationBuilder.get();			
			System.out.println(resp.toString());
			if(resp.getStatus() == ConstantesPagos.RESP_ESTATUS_CORRECTO) {
				respGas = resp.readEntity(GasolinerasClienteResponse.class);
				//respGas = GasolinerasClienteResponse.createResponse(resp);

			}
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.close();
		}

		return respGas;
	}*/

	public static GasolinerasClienteResponse ConsultaGasolineras() {

		Client cliente = ClientHelper.createClient();
		String jsonResp = "";
		GasolinerasClienteResponse voResp = null;

		String njsn = "";
		try {

			WebResource service = cliente.resource(ConstantesPagos.URL_SERVICIO_GASOLINERAS);
			jsonResp = service.path(ConstantesPagos.PATH_SERVICE)
					.type("application/json")
					.header("Accept", MediaType.APPLICATION_JSON)
					.get(String.class);
			if(jsonResp != null && jsonResp.length() > 0) {
				njsn = new String(jsonResp.getBytes(ConstantesPagos.ISO_8859_1));
				ObjectMapper objectMapper = new ObjectMapper();
				voResp = objectMapper.readValue(njsn, GasolinerasClienteResponse.class);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voResp;
	}
}
