/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.spring.boot.gae.ecommercespa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.NoArgsConstructor;
import org.tyaa.java.spring.boot.gae.ecommercespa.entity.User;

/**
 *
 * @author student
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class RoleModel {
    public Long id;
    public String name;
    public List<User> users;

    public RoleModel(String name) {
        this.name = name;
    }

    public RoleModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
