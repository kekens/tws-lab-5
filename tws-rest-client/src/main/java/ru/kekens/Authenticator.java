package ru.kekens;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Provider
public class Authenticator implements ClientRequestFilter {

    private String user;
    private String password;

    public Authenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add(
                HttpHeaders.AUTHORIZATION, getBasicAuthentication());
    }

    private String getBasicAuthentication() throws UnsupportedEncodingException {
        String userAndPassword = this.user + ":" + this.password;
        byte[] userAndPasswordBytes = userAndPassword.getBytes("UTF-8");
        return "Basic " + Base64.getEncoder().encodeToString(userAndPasswordBytes);
    }
}