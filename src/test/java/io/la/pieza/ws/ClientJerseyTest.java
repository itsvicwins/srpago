package io.la.pieza.ws;

public class ClientJerseyTest {

	
	/* prueba completa con jersey 2 y jpa 2.2
	public static void main(String []args) {

		Configuration config = new Configuration();
		config.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
		config.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		config.setProperty("hibernate.connection.username", "data_web");
		config.setProperty("hibernate.connection.password", "l4p13z4");
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
		config.addAnnotatedClass(Pago.class);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
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

			GasolinerasClienteResponse actual = get();
			if(actual != null && actual.getResultadoConsulta().equalsIgnoreCase(ConstantesPagos.CONSULTA_CORRECTA)) {
				
			try {	
				System.out.println("Respuesta Servicio Https:");
				System.out.println(actual.toString());
				MessageInput input = JsonUtils.getInputFromJson(jsonEntrada);
				DatosGasolinera dato = findByGasStation(input.getGasStation(), actual.getListaEESSPrecio());
				Pago entity = input.convertToEntity(dato);
				sessionFactory = config.buildSessionFactory();
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				
				session.save(entity);
				tx.commit();
			}catch (HibernateException e) {
				if(tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
				
			} catch (ConstraintViolationException e) {
				StringBuilder stb1 = new StringBuilder();
				Set<ConstraintViolation<?>> violations = ((ConstraintViolationException)e.getCause()).getConstraintViolations();
				violations.forEach(v -> stb1.append(v));
				e.printStackTrace();
								
			}finally {
				session.close();
				sessionFactory.close();
			}
		}else {
			System.out.println("No se pudo realizar la consulta");
		}
	}

	private static GasolinerasClienteResponse get()  {


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
	}

	private static DatosGasolinera findByGasStation(String gasStation, List<DatosGasolinera> list) {
		List<DatosGasolinera> filtrada = list.stream().filter(d -> d.getIDPosteMaritimo().equalsIgnoreCase(gasStation)).collect(Collectors.toList());
		DatosGasolinera dato = null;
		if(filtrada.size() > 0)
			dato = filtrada.get(0);
	
		return dato;
	}*/
	
}
