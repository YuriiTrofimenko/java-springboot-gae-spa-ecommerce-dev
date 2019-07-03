/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.spring.boot.gae.ecommercespa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tyaa.java.spring.boot.gae.ecommercespa.model.JsonHttpResponse;
import org.tyaa.java.spring.boot.gae.ecommercespa.service.AuthService;

/**
 *
 * @author student
 */
@RestController
@RequestMapping("/api/init")
public class InitController {
    
    @Autowired
    private AuthService authService;

    @GetMapping("/{id}")
    public JsonHttpResponse makeAdmin(@PathVariable Long id) throws Exception {
    
        return authService.makeUserAdmin(id);
    }
}
