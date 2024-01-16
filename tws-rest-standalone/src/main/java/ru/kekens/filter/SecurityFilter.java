package ru.kekens.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String method = requestContext.getMethod();

        // Если метод не GET (READ), то проверяем параметры пользователя
        if (!"GET".equals(method)) {
            String authHeader = requestContext.getHeaderString("Authorization");

            // Если не передан хедер, или его значение неверно, то бросаем ошибку 401 Unauthorized
            if (authHeader == null || !authHeader.startsWith("Basic")) {
                requestContext.abortWith(Response.status(401).header("WWW-Authenticate", "Basic").build());
                return;
            }

            // Парсим хедер и проверяем
            String token = (new String(Base64.getDecoder().decode(authHeader.split(" ")[1]), StandardCharsets.UTF_8));

            if (token.equals("student:password")) {
            } else {
                requestContext.abortWith(Response.status(401).build());
            }
        }
    }

}
