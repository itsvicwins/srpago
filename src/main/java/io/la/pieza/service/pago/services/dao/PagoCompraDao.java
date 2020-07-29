package io.la.pieza.service.pago.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import io.la.pieza.service.pago.common.ConstantesPagos;
import io.la.pieza.service.pago.entitys.Pago;
import io.la.pieza.service.pago.response.CompraGasolinaResponse;

@Transactional
@Service
public class PagoCompraDao implements IPagoCompraDao {
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSourceSr;

	@Bean(name = "dataSourceSr", destroyMethod="")
	public void setDataSource() {
	    final JndiDataSourceLookup jndiDataSource= new JndiDataSourceLookup();
	    jndiDataSource.setResourceRef(true);
	    this.dataSourceSr = jndiDataSource.getDataSource("java:jdbc/dataSourceSrPago");
	}
	
	private void setConfig() {
		this.transactionManager = new DataSourceTransactionManager(this.dataSourceSr);
		this.jdbcTemplate = new JdbcTemplate(dataSourceSr);
	}

	@Transactional
	public CompraGasolinaResponse save(Pago pago) {
		setConfig();
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
	
		try {
			
			this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String sql =" INSERT INTO PAGOS_GASOLINA(" 
				+"    ID_PAGO, " 
				+"    EMAIL, " 
				+"    NAME , " 
				+"    LAST_NAME, " 
				+"    CARD_NUMBER, " 
				+"    EXPIRATION_YEAR, " 
				+"    EXPIRATION_MONTH , " 
				+"    GAS_TYPE , " 
				+"    AMOUNT , " 
				+"    GASSTATION , " 
				+"    SELLERNAME, " 
				+"    CODIGOPOSTAL , " 
				+"    DIRECCION , " 
				+"    HORARIO, " 
				+"    LATITUD, " 
				+"    LOCALIDAD , " 
				+"    MUNICIPIO , " 
				+"    PRECIOGASOLEOA, " 
				+"    PRECIOGASOLEOB, " 
				+"    PRECIOGASOLINA95E10 , " 
				+"    PRECIOGASOLINA95E5, " 
				+"    PRECIOGASOLEOMARITIMO , " 
				+"    PROVINCIA , " 
				+"    PUERTO, " 
				+"    REMISION, " 
				+"    ROTULO, " 
				+"    TIPOVENTA , " 
				+"    IDPOSTEMARITIMO, " 
				+"    IDMUNICIPIO , " 
				+"    IDPROVINCIA , " 
				+"    IDCCAA " 
				+"  ) " 
				+" VALUES (SYS.seq_pagos.NEXTVAL, "  
				+"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ";
				
	            PreparedStatement ps = con.prepareStatement(sql);
			
	            ps.setString(1, pago.getEmail());
	            ps.setString(2, pago.getName());
	            ps.setString(3, pago.getLastName());
	            ps.setString(4, pago.getCardnumber());
	            ps.setInt(5, pago.getExpirationDateYear());
	            ps.setInt(6, pago.getExpirationDateMonth());
	            ps.setInt(7, pago.getGasType());
	            ps.setDouble(8, pago.getAmount());
	            ps.setString(9, pago.getGasStation());
	            ps.setString(10, pago.getSellerName());
	            ps.setString(11, pago.getCodigoPostal());
	            ps.setString(12, pago.getDireccion());
	            ps.setString(13, pago.getHorario());
	            ps.setString(14, pago.getLatitud());
	            ps.setString(15, pago.getLocalidad());
	            ps.setString(16, pago.getMunicipio());
	            ps.setString(17, pago.getPrecioGasoleoA());
	            ps.setString(18, pago.getPrecioGasoleoB());
	            ps.setString(19, pago.getPrecioGasolina95E10());
	            ps.setString(20, pago.getPrecioGasolina95E5());
	            ps.setString(21, pago.getPrecioGasoleoMaritimo());
	            ps.setString(22, pago.getProvincia());
	            ps.setString(23, pago.getPuerto());
	            ps.setString(24, pago.getRemision());
	            ps.setString(25, pago.getRotulo());
	            ps.setString(26, pago.getTipoVenta());
	            ps.setString(27, pago.getIdPosteMaritimo());
	            ps.setString(28, pago.getIdMunicipio());
	            ps.setString(29, pago.getIdProvincia());
	            ps.setString(30, pago.getIdCCAA());
				
	            return ps;
			}
		});
			this.transactionManager.commit(status);
			return CompraGasolinaResponse.createResponse(true, ConstantesPagos.MSG_TRANSACTION_SUCCESS, "");
		}catch (DataAccessException  e) {
			if(this.transactionManager != null)
				this.transactionManager.rollback(status);
			return CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_TRANSACTION_FAIL, e.getMessage());
		}catch (NullPointerException e) {
			return CompraGasolinaResponse.createResponse(false, ConstantesPagos.MSG_TRANSACTION_FAIL, e.getMessage());
		}
	}

	/*
	 * @Override public CompraGasolinaResponse save(Pago pago) {
	 * 
	 * Configuration config = new Configuration();
	 * config.setProperty("hibernate.connection.driver_class",
	 * "oracle.jdbc.OracleDriver"); config.setProperty("hibernate.connection.url",
	 * "jdbc:oracle:thin:@localhost:1521:xe");
	 * config.setProperty("hibernate.connection.username", "data_web");
	 * config.setProperty("hibernate.connection.password", "l4p13z4");
	 * config.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.Oracle8iDialect");
	 * config.addAnnotatedClass(Pago.class);
	 * 
	 * SessionFactory sessionFactory = null; Session session = null; Transaction tx
	 * = null; StringBuilder stbMsg = new StringBuilder(); boolean txSuccess =
	 * false; String mensajeTx = "";
	 * 
	 * try { sessionFactory = config.buildSessionFactory(); session =
	 * sessionFactory.openSession(); tx = session.beginTransaction();
	 * 
	 * session.save(pago); tx.commit(); mensajeTx =
	 * ConstantesPagos.MSG_TRANSACTION_SUCCESS; txSuccess = true;
	 * 
	 * }catch (HibernateException e) { if(tx != null) { tx.rollback(); } mensajeTx =
	 * ConstantesPagos.MSG_TRANSACTION_FAIL; txSuccess = false; e.printStackTrace();
	 * 
	 * } catch (ConstraintViolationException e) { StringBuilder stb1 = new
	 * StringBuilder(); Set<ConstraintViolation<?>> violations =
	 * ((ConstraintViolationException)e.getCause()).getConstraintViolations();
	 * violations.forEach(v -> stb1.append(v)); stbMsg = stb1; mensajeTx =
	 * ConstantesPagos.MSG_PARAMETROS_INCORRECTOS; txSuccess = false;
	 * e.printStackTrace();
	 * 
	 * }finally { session.close(); sessionFactory.close(); }
	 * 
	 * return CompraGasolinaResponse.createResponse(txSuccess, mensajeTx,
	 * stbMsg.toString()); }
	 * 
	 * 
	 * 
	 * @Override public CompraGasolinaResponse save(Pago pago) {
	 * 
	 * EntityManagerFactory factory =
	 * Persistence.createEntityManagerFactory(ConstantesPagos.PERSISTENCE_UNIT_NAME)
	 * ; EntityManager em = factory.createEntityManager(); StringBuilder stbMsg =
	 * new StringBuilder(); boolean txSuccess = false; String mensajeTx = "";
	 * 
	 * EntityTransaction tx = null; try { tx = em.getTransaction(); tx.begin();
	 * em.persist(pago); tx.commit(); mensajeTx =
	 * ConstantesPagos.MSG_TRANSACTION_SUCCESS; txSuccess = true;
	 * 
	 * }catch (HibernateException e) { if(tx != null) { tx.rollback(); } mensajeTx =
	 * ConstantesPagos.MSG_TRANSACTION_FAIL; txSuccess = false;
	 * 
	 * } catch (ConstraintViolationException e) { StringBuilder stb1 = new
	 * StringBuilder(); Set<ConstraintViolation<?>> violations =
	 * ((ConstraintViolationException)e.getCause()).getConstraintViolations();
	 * violations.forEach(v -> stb1.append(v)); stbMsg = stb1;
	 * 
	 * mensajeTx = ConstantesPagos.MSG_PARAMETROS_INCORRECTOS; txSuccess = false;
	 * 
	 * }finally { em.close(); } return
	 * CompraGasolinaResponse.createResponse(txSuccess, mensajeTx,
	 * stbMsg.toString()); }
	 */

}
