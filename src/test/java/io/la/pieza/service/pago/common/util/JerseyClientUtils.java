package io.la.pieza.service.pago.common.util;

public class JerseyClientUtils {

	/*
	public static Response getRestServiceHttps(String url, String pathService) {
	
		Client client = null;
		Response clientResponse = null;
		try {
			client = JerseyHttpClientFactory.getJerseyHTTPSClient();
			Invocation.Builder invocationBuilder = client.target(url)
					.path(pathService).
					request(MediaType.APPLICATION_JSON+ ConstantesPagos.CHARSET_UTF8);
			clientResponse   = invocationBuilder.get();			
			System.out.println(clientResponse.toString());

		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.close();
		}
		return clientResponse;
	}*/
	
}
