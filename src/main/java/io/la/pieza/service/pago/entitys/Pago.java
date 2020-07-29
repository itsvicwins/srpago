package io.la.pieza.service.pago.entitys;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.la.pieza.service.pago.common.ConstantesPagos;

public class Pago implements Serializable {

	private static final long serialVersionUID = 2064496345926729840L;

	 private Long idPago;
		
	 @Pattern(regexp = ConstantesPagos.EMAIL_PATTERN, message = "El formato del email es inválido. ")
	 private String email;
	 
	 @NotNull(message = "El Nombre no puede ser nulo. ")
	 private String name;
	 
	 @NotNull(message = "Los apellidos no pueden ser nulos. ")
	 private String lastName;
	 
	 @NotNull
	 @Size(min=16, max=16)
	 private String cardnumber;
	 
	 @NotNull
	 @Size(min=4, max=4,message = "El año de expiración debe ser de 4 dígitos. ")
	 private Integer expirationDateYear;
	 
	 @NotNull
	 @Size(min=2, max=2, message = "El mes de expiración debe ser de 2 dígitos ")
	 private Integer expirationDateMonth;
	 
	 @NotNull(message = "El tipo de gasolina no puede ser nula. ")
	 private Integer gasType;
	
	 @NotNull
	 @Digits(integer=10, fraction=2, message = "El monto del pago debe tener máximo 10 enteros y 2 decimales. ")
	 private Double amount;
	 
	 @NotNull(message = "El nombre de la estación de gasolina no puede ser nulo. ")
	 private String gasStation;
	 
	 @NotNull(message = "El nombre del vendedor no puede ser nulo. ")
	 private String sellerName;
	 
	 @NotNull(message = "El dato codigoPostal no puede ser nulo. ")
	 private String codigoPostal;

	 @NotNull(message = "El dato direccion no puede ser nulo. ")
	 private String direccion;

	 @NotNull(message = "El dato horario no puede ser nulo. ")
	 private String horario;

	 @NotNull(message = "El dato latitud no puede ser nulo. ")
	 private String latitud;

	 @NotNull(message = "El dato localidad no puede ser nulo. ")
	 private String localidad;

	 @NotNull(message = "El dato municipio no puede ser nulo. ")
	 private String municipio;

	 @NotNull(message = "El dato precioGasoleoA no puede ser nulo. ")
	 private String precioGasoleoA;

	 @NotNull(message = "El dato precioGasoleoB no puede ser nulo. ")
	 private String precioGasoleoB;

	 @NotNull(message = "El dato precioGasolina95E10 no puede ser nulo. ")
	 private String precioGasolina95E10;

	 @NotNull(message = "El dato precioGasolina95E5 no puede ser nulo. ")
	 private String precioGasolina95E5;

	 @NotNull(message = "El dato precioGasoleoMaritimo no puede ser nulo. ")
	 private String precioGasoleoMaritimo;

	 @NotNull(message = "El dato provincia no puede ser nulo. ")
	 private String provincia;

	 @NotNull(message = "El dato puerto no puede ser nulo. ")
	 private String puerto;

	 @NotNull(message = "El dato remision no puede ser nulo. ")
	 private String remision;

	 @NotNull(message = "El dato rotulo no puede ser nulo. ")
	 private String rotulo;

	 @NotNull(message = "El dato tipoVenta no puede ser nulo. ")
	 private String tipoVenta;

	 @NotNull(message = "El dato idPosteMaritimo no puede ser nulo. ")
	 private String idPosteMaritimo;

	 @NotNull(message = "El dato idMunicipio no puede ser nulo. ")
	 private String idMunicipio;

	 @NotNull(message = "El dato idProvincia no puede ser nulo. ")
	 private String idProvincia;

	 @NotNull(message = "El dato idCCAA no puede ser nulo. ")
	 private String idCCAA;


	public Long getIdPago() {
		return idPago;
	}

	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Integer getExpirationDateYear() {
		return expirationDateYear;
	}

	public void setExpirationDateYear(Integer expirationDateYear) {
		this.expirationDateYear = expirationDateYear;
	}

	public Integer getExpirationDateMonth() {
		return expirationDateMonth;
	}

	public void setExpirationDateMonth(Integer expirationDateMonth) {
		this.expirationDateMonth = expirationDateMonth;
	}

	public Integer getGasType() {
		return gasType;
	}

	public void setGasType(Integer gasType) {
		this.gasType = gasType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getGasStation() {
		return gasStation;
	}

	public void setGasStation(String gasStation) {
		this.gasStation = gasStation;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPrecioGasoleoA() {
		return precioGasoleoA;
	}

	public void setPrecioGasoleoA(String precioGasoleoA) {
		this.precioGasoleoA = precioGasoleoA;
	}

	public String getPrecioGasoleoB() {
		return precioGasoleoB;
	}

	public void setPrecioGasoleoB(String precioGasoleoB) {
		this.precioGasoleoB = precioGasoleoB;
	}

	public String getPrecioGasolina95E10() {
		return precioGasolina95E10;
	}

	public void setPrecioGasolina95E10(String precioGasolina95E10) {
		this.precioGasolina95E10 = precioGasolina95E10;
	}

	public String getPrecioGasolina95E5() {
		return precioGasolina95E5;
	}

	public void setPrecioGasolina95E5(String precioGasolina95E5) {
		this.precioGasolina95E5 = precioGasolina95E5;
	}

	public String getPrecioGasoleoMaritimo() {
		return precioGasoleoMaritimo;
	}

	public void setPrecioGasoleoMaritimo(String precioGasoleoMaritimo) {
		this.precioGasoleoMaritimo = precioGasoleoMaritimo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getRemision() {
		return remision;
	}

	public void setRemision(String remision) {
		this.remision = remision;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public String getIdPosteMaritimo() {
		return idPosteMaritimo;
	}

	public void setIdPosteMaritimo(String idPosteMaritimo) {
		this.idPosteMaritimo = idPosteMaritimo;
	}

	public String getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdCCAA() {
		return idCCAA;
	}

	public void setIdCCAA(String idCCAA) {
		this.idCCAA = idCCAA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
