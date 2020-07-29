package io.la.pieza.service.pago.request;

import javax.xml.bind.annotation.XmlRootElement;

import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.vo.DatosGasolinera;

@XmlRootElement
public class MessageInput {

	private String email;
	private String name;
	private String lastName;
	private String cardNumber;
	private int expirationDateYear;
	private int expirationDateMonth;
	private Integer gasType;
	private Double amount;
	private String gasStation;
	private String sellerName;
	
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
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpirationDateYear() {
		return expirationDateYear;
	}
	public void setExpirationDateYear(int expirationDateYear) {
		this.expirationDateYear = expirationDateYear;
	}
	public int getExpirationDateMonth() {
		return expirationDateMonth;
	}
	public void setExpirationDateMonth(int expirationDateMonth) {
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
	
	@Override
	public String toString() {
		return "MessageInput [email=" + email + ", name=" + name + ", lastName=" + lastName + ", cardNumber="
				+ cardNumber + ", expirationDateYear=" + expirationDateYear + ", expirationDateMonth="
				+ expirationDateMonth + ", gasType=" + gasType + ", amount=" + amount + ", gasStation=" + gasStation
				+ ", sellerName=" + sellerName + "]";
	}
	
	public Pago convertToEntity(DatosGasolinera dato) {
		
		Pago pago = new Pago();		
		pago.setEmail(this.email);
		pago.setName(this.name);
		pago.setLastName(this.lastName);
		pago.setCardnumber(this.cardNumber);
		pago.setExpirationDateYear(this.expirationDateYear);
		pago.setExpirationDateMonth(this.expirationDateMonth);
		pago.setGasType(this.gasType);
		pago.setAmount(this.amount);
		pago.setGasStation(this.gasStation);
		pago.setSellerName(this.sellerName);
		
		pago.setCodigoPostal(dato.getCodigoPostal());
		pago.setDireccion(dato.getDireccion());
		pago.setHorario(dato.getHorario());
		pago.setLatitud(dato.getLatitud());
		pago.setLocalidad(dato.getLocalidad());
		pago.setMunicipio(dato.getMunicipio());
		pago.setPrecioGasoleoA(dato.getPrecioGasoleoA());
		pago.setPrecioGasoleoB(dato.getPrecioGasoleoB());
		pago.setPrecioGasolina95E10(dato.getPrecioGasolina95E10());
		pago.setPrecioGasolina95E5(dato.getPrecioGasolina95E5());
		pago.setPrecioGasoleoMaritimo(dato.getPrecioGasoleoMaritimo());
		pago.setProvincia(dato.getProvincia());
		pago.setPuerto(dato.getPuerto());
		pago.setRemision(dato.getRemision());
		pago.setRotulo(dato.getRotulo());
		pago.setTipoVenta(dato.getTipoVenta());
		pago.setIdPosteMaritimo(dato.getIDPosteMaritimo());
		pago.setIdMunicipio(dato.getIdMunicipio());
		pago.setIdProvincia(dato.getIdProvincia());
		pago.setIdCCAA(dato.getIdCCAA());
		
		return pago;
	}
}