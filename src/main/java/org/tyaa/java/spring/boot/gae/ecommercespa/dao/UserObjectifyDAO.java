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
import org.tyaa.java.spring.boot.gae.ecommercespa.entity.User;
import org.tyaa.java.spring.boot.gae.ecommercespa.util.CopyHelper;

/**
 *
 * @author student
 */
@Repository
public class UserObjectifyDAO extends AbstractObjectifyDAO<User>{
    
    public User read(String _name) throws Exception {
                    
        User finalUserEntity = new User();
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                User userEntityResult =
                    ofy().load().type(User.class)
                        .filter("name", _name)
                        .first()
                        .now();
                if (userEntityResult != null) {
                    CopyHelper.copy(userEntityResult, finalUserEntity);
                }
            }
        });
        return finalUserEntity;
    }
}
