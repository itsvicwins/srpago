package io.la.pieza.service.pago.response;

public class CompraGasolinaResponse {

	private boolean success;
	private String message;
	private String error;
	
	public CompraGasolinaResponse(boolean estado, String msg, String error) {
			this.success = estado;
			this.message = msg;
			this.error = error;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public static CompraGasolinaResponse createResponse(boolean state, String m, String err) {
		
		CompraGasolinaResponse resp = new CompraGasolinaResponse(state, m, err);
		
		return resp;
	}
}
