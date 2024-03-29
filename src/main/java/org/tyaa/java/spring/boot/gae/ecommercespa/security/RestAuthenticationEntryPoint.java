/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.spring.boot.gae.ecommercespa.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author student
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint{
    @Override
    public void commence(
            HttpServletRequest request
            , HttpServletResponse response
            , AuthenticationException ex
    ) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, 
          "Unauthorized");
    }
}
