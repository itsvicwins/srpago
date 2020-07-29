package io.la.pieza.service.pago.response;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import io.la.pieza.service.pago.common.ConstantesPagos;
import io.la.pieza.service.pago.vo.DatosGasolinera;

@XmlRootElement
public class GasolinerasClienteResponse {

	@JsonProperty("Fecha")
	private String Fecha;
	
	@JsonProperty("ListaEESSPrecio")
	private List<DatosGasolinera> ListaEESSPrecio;
	
	@JsonProperty("Nota")
	private String Nota;
	
	@JsonProperty("ResultadoConsulta")
	private String ResultadoConsulta;

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String Fecha) {
		this.Fecha = Fecha;
	}

	public List<DatosGasolinera> getListaEESSPrecio() {
		return ListaEESSPrecio;
	}

	public void setListaEESSPrecio(List<DatosGasolinera> list) {
		this.ListaEESSPrecio = list;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String Nota) {
		this.Nota = Nota;
	}

	public String getResultadoConsulta() {
		return ResultadoConsulta;
	}

	public void setResultadoConsulta(String ResultadoConsulta) {
		this.ResultadoConsulta = ResultadoConsulta;
	}

	@Override
	public String toString() {
		return "GasolinerasClienteResponse [Fecha=" + Fecha + ", ListaEESSPrecio=" + printLista(ListaEESSPrecio)  + ", Nota=" + Nota
				+ ", ResultadoConsulta=" + ResultadoConsulta + "]";
	}

	private String printLista(List<DatosGasolinera> lst) {
		
		StringBuilder sb = new StringBuilder();
		lst.forEach(c -> sb.append(c + ConstantesPagos.CHAR_COMA));
		
		return sb.toString();
	}

	public static GasolinerasClienteResponse createResponse(Response resp) {

		String json = " { "
				+ "    \"Fecha\": \"23/07/2020 1:03:52\",     "
				+ "    \"ListaEESSPrecio\": [ "
				+ "        {      "
				+ "            \"C.P.\": \"03001\", "
				+ "            \"Direccion\": \"MUELLE 8, ZONA DE LEVANTE, S/N\", "
				+ "            \"Horario\": \"L-D: 08:00-21:00\",     "
				+ "            \"Latitud\": \"38,339167\",      "
				+ "            \"Localidad\": \"ALICANTE/ALACANT\",   "
				+ "            \"Longitud (WGS84)\": \"-0,481472\",   "
				+ "            \"Municipio\": \"Alicante/Alacant\",   "
				+ "            \"Precio Gasoleo A habitual\": \"1,079\",    "
				+ "            \"Precio Gasoleo B\": \"\",      "
				+ "            \"Precio Gasolina 95 E10\": \"\",      "
				+ "            \"Precio Gasolina 95 E5\": \"1,209\",  "
				+ "            \"Precio Gasoleo para uso maritimo\": \"\",  "
				+ "            \"Provincia\": \"ALICANTE\",     "
				+ "            \"Puerto\": \"ALICANTE\",  "
				+ "            \"Remision\": \"dm\",      "
				+ "            \"Rotulo\": \"MARINA ALICANTE\", "
				+ "            \"Tipo Venta\": \"Suministro a barcos deportivos o de recreo\",      "
				+ "            \"IDPosteMaritimo\": \"209\",    "
				+ "            \"IDMunicipio\": \"152\",  "
				+ "            \"IDProvincia\": \"03\",   "
				+ "            \"IDCCAA\": \"10\"   "
				+ "        }      "
				+ "    ],   "
				+ "    \"Nota\": \"Archivo de todos los productos en todas las estaciones de servicio. La actualizacion de precios se realiza cada media hora, con los precios en vigor en ese momento.\", "
				+ "    \"ResultadoConsulta\": \"OK\"      "
				+ " }  ";
		
		GasolinerasClienteResponse response = null;
		try {
			String njsn = new String(json.getBytes("ISO-8859-1"), "UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			response = objectMapper.readValue(njsn, GasolinerasClienteResponse.class);
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
		return response;
	}
}
