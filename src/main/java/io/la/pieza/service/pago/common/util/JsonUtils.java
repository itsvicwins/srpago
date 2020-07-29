package io.la.pieza.service.pago.common.util;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import io.la.pieza.service.pago.request.MessageInput;

public class JsonUtils {

	public static MessageInput getInputFromJson(String jsonEntrada) {

		MessageInput in = null;
		try {
			String njsn = new String(jsonEntrada.getBytes("ISO-8859-1"));
			ObjectMapper objectMapper = new ObjectMapper();
			in = objectMapper.readValue(njsn, MessageInput.class);
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
		
		return in;
	}
	
}
