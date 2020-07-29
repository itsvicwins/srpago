package io.la.pieza.service.pago.common;

public class ConstantesPagos {

	public static final String PERSISTENCE_UNIT_NAME = "ComprasPago";
	
	public static final String ERR_ENTRADA_VACIA = "No se pudo mapear el objeto de entrada correctamente.";
	public static final String ERR_TRANSACTION_SUCCESS = null;
	
	public static final String EMAIL_PATTERN 
    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static final String MSG_ENTRADA_VACIA = "Error al mapear la entrada.";
	public static final String MSG_TRANSACTION_SUCCESS = "Transacción Exitosa.";
	public static final String MSG_TRANSACTION_FAIL = "Ocurrio un error al realizar la transacción.";
	public static final String MSG_PARAMETROS_INCORRECTOS = "Los parámetros de entrada no cumplen el formato.";
	
	public static final String URL_SERVICIO_GASOLINERAS = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/";
	public static final String PATH_SERVICE = "PostesMaritimos";
	public static final int RESP_ESTATUS_CORRECTO = 200;
	public static final String CONSULTA_CORRECTA = "OK";
	public static final String CHARSET_ISO_8859_1 = ";charset=ISO-8859-1";
	public static final String ISO_8859_1 = "ISO-8859-1";

	public static final String MSG_CLIENTE_INCORRECTA = "Error al realizar la consulta de la información de Gasolineras";

	public static final String ERR_COMUNICACION_CLIENTE = "Hubo un problema de comunicación con el cliente.";

	public static final String CHAR_COMA = ", ";

	public static final String URL_SERVICIO_PAGO_GASOLINA = "http://localhost:7001/WS_ComprasPago/servicios/srpago";

	public static final String PATH_SERVICE_GASOLINA = "/realizarPagoGasolina";
	
	
}
