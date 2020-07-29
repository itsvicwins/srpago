package io.la.pieza.service.pago.rest;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NoOpHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
