package io.la.pieza.service.pago.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/servicios")
public class RestApplication extends Application {

	public Set<java.lang.Class<?>> getClasses() {
		Set<java.lang.Class<?>> s = new HashSet<Class<?>>();
		s.add(WSPagos.class);
		return s;
	}

}
