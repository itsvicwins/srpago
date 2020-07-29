package io.la.pieza.ws;

public class TestHibernateFactory {
	
	/*
	
	private String jsonEntrada = "{"
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
	
	@Test
	public void test() {

		MessageInput inp = JsonUtils.getInputFromJson(jsonEntrada);

		try {
			GasolinerasClienteResponse voRespo = get();
			if(voRespo != null && voRespo.getResultadoConsulta().equalsIgnoreCase(ConstantesPagos.CONSULTA_CORRECTA)) {
				DatosGasolinera  dat = findByGasStation(inp.getGasStation(), voRespo.getListaEESSPrecio());
				Pago entity = inp.convertToEntity(dat);
				saveEntity(entity);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void saveEntity(Pago ent) {

		SessionFactory sessionFact = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sessionFact =  getSessionFactory();
			session = sessionFact.openSession();
			tx = session.beginTransaction();
			session.save(ent);
			tx.commit();
			
		}catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFact.close();
		}
		
	}


	private SessionFactory getSessionFactory() {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory  = null;
				// configures settings from hibernate.cfg.xml
				
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return sessionFactory;
	}

	private static DatosGasolinera findByGasStation(String gasStation, List<DatosGasolinera> list) {
		List<DatosGasolinera> filtrada = list.stream().filter(d -> d.getIDPosteMaritimo().equalsIgnoreCase(gasStation)).collect(Collectors.toList());
		DatosGasolinera dato = null;
		if(filtrada.size() > 0)
			dato = filtrada.get(0);
	
		return dato;
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
	}*/
}
