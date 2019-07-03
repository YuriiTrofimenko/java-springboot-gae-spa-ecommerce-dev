/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.spring.boot.gae.ecommercespa.dao;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.VoidWork;
import org.springframework.stereotype.Repository;
import org.tyaa.java.spring.boot.gae.ecommercespa.entity.Role;
import org.tyaa.java.spring.boot.gae.ecommercespa.util.CopyHelper;

/**
 *
 * @author student
 */
@Repository
public class RoleObjectifyDAO extends AbstractObjectifyDAO<Role>{
    
    public Role read(String _name) throws Exception {
            
        Role roleEntity = null;
        
        final Role finalRoleEntity = new Role();
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                Role roleEntityResult =
                    ofy().load().type(Role.class)
                        .filter("name", _name)
                        .first()
                        .now();
                if (roleEntityResult != null) {
                    CopyHelper.copy(roleEntityResult, finalRoleEntity);
                }
            }
        });
        roleEntity = finalRoleEntity;
            
        return roleEntity;
    }
}
