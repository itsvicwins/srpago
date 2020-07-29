package io.la.pieza.service.pago.vo;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class DatosGasolinera {

	@JsonProperty("C.P.")
	private String cp;

	@JsonProperty("Dirección")
	private String Direccion;

	@JsonProperty("Horario")
	private String Horario;

	@JsonProperty("Latitud")
	private String Latitud;

	@JsonProperty("Localidad")
	private String Localidad;

	@JsonProperty("Longitud (WGS84)")
	private String Longitud;

	@JsonProperty("Municipio")
	private String Municipio;

	@JsonProperty("Precio Gasoleo A habitual")
	private String PrecioGasoleoAHabitual;

	@JsonProperty("Precio Gasoleo B")
	private String PrecioGasoleoB;

	@JsonProperty("Precio Gasolina 95 E10")
	private String PrecioGasolina95E10;

	@JsonProperty("Precio Gasolina 95 E5")
	private String PrecioGasolina95E5;

	@JsonProperty("Precio Gasóleo para uso marítimo")
	private String PrescioGasoleoUsoMaritimo;

	@JsonProperty("Provincia")
	private String Provincia;

	@JsonProperty("Puerto")
	private String Puerto;

	@JsonProperty("Remisión")
	private String Remision;

	@JsonProperty("Rótulo")
	private String Rotulo;

	@JsonProperty("Tipo Venta")
	private String TipoVenta;

	@JsonProperty("IDPosteMaritimo")
	private String IDPosteMaritimo;

	@JsonProperty("IDMunicipio")
	private String IDMunicipio;

	@JsonProperty("IDProvincia")
	private String IdProvincia;

	@JsonProperty("IDCCAA")
	private String IDCCAA;
	
	public String getCodigoPostal() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	public String getLatitud() {
		return Latitud;
	}
	public void setLatitud(String latitud) {
		Latitud = latitud;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getLongitud() {
		return Longitud;
	}
	public void setLongitud(String longitud) {
		Longitud = longitud;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public String getPrecioGasoleoA() {
		return PrecioGasoleoAHabitual;
	}
	public void setPrecioGasoleoAHabitual(String precioGasoleoAHabitual) {
		PrecioGasoleoAHabitual = precioGasoleoAHabitual;
	}
	public String getPrecioGasoleoB() {
		return PrecioGasoleoB;
	}
	public void setPrecioGasoleoB(String precioGasoleoB) {
		PrecioGasoleoB = precioGasoleoB;
	}
	public String getPrecioGasolina95E10() {
		return PrecioGasolina95E10;
	}
	public void setPrecioGasolina95E10(String precioGasolina95E10) {
		PrecioGasolina95E10 = precioGasolina95E10;
	}
	public String getPrecioGasolina95E5() {
		return PrecioGasolina95E5;
	}
	public void setPrecioGasolina95E5(String precioGasolina95E5) {
		PrecioGasolina95E5 = precioGasolina95E5;
	}
	public String getPrecioGasoleoMaritimo() {
		return PrescioGasoleoUsoMaritimo;
	}
	public void setPrescioGasoleoUsoMaritimo(String prescioGasoleoUsoMaritimo) {
		PrescioGasoleoUsoMaritimo = prescioGasoleoUsoMaritimo;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getPuerto() {
		return Puerto;
	}
	public void setPuerto(String puerto) {
		Puerto = puerto;
	}
	public String getRemision() {
		return Remision;
	}
	public void setRemision(String remision) {
		Remision = remision;
	}
	public String getRotulo() {
		return Rotulo;
	}
	public void setRotulo(String rotulo) {
		Rotulo = rotulo;
	}
	public String getTipoVenta() {
		return TipoVenta;
	}
	public void setTipoVenta(String tipoVenta) {
		TipoVenta = tipoVenta;
	}
	public String getIDPosteMaritimo() {
		return IDPosteMaritimo;
	}
	public void setIDPosteMaritimo(String iDPosteMaritimo) {
		IDPosteMaritimo = iDPosteMaritimo;
	}
	public String getIdMunicipio() {
		return IDMunicipio;
	}
	public void setIDMunicipio(String iDMunicipio) {
		IDMunicipio = iDMunicipio;
	}
	public String getIdProvincia() {
		return IdProvincia;
	}
	public void setIdProvincia(String idProvincia) {
		IdProvincia = idProvincia;
	}
	public String getIdCCAA() {
		return IDCCAA;
	}
	public void setIDCCAA(String iDCCAA) {
		IDCCAA = iDCCAA;
	}
	@Override
	public String toString() {
		return "DatosGasolinera [cp=" + cp + ", Direccion=" + Direccion + ", Horario=" + Horario + ", Latitud="
				+ Latitud + ", Localidad=" + Localidad + ", Longitud=" + Longitud + ", Municipio=" + Municipio
				+ ", PrecioGasoleoAHabitual=" + PrecioGasoleoAHabitual + ", PrecioGasoleoB=" + PrecioGasoleoB
				+ ", PrecioGasolina95E10=" + PrecioGasolina95E10 + ", PrecioGasolina95E5=" + PrecioGasolina95E5
				+ ", PrescioGasoleoUsoMaritimo=" + PrescioGasoleoUsoMaritimo + ", Provincia=" + Provincia + ", Puerto="
				+ Puerto + ", Remision=" + Remision + ", Rotulo=" + Rotulo + ", TipoVenta=" + TipoVenta
				+ ", IDPosteMaritimo=" + IDPosteMaritimo + ", IDMunicipio=" + IDMunicipio + ", IdProvincia="
				+ IdProvincia + ", IDCCAA=" + IDCCAA + "]";
	}
}
