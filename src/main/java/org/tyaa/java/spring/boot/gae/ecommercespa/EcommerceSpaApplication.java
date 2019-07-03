package org.tyaa.java.spring.boot.gae.ecommercespa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan({
    "org.tyaa.java.spring.boot.gae.ecommercespa.controller"
        , "org.tyaa.java.spring.boot.gae.ecommercespa.service"
        , "org.tyaa.java.spring.boot.gae.ecommercespa.dao"
        , "org.tyaa.java.spring.boot.gae.ecommercespa.aspect"
        , "org.tyaa.java.spring.boot.gae.ecommercespa.security"
})
@EnableAspectJAutoProxy
public class EcommerceSpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSpaApplication.class, args);
	}

}
