/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.spring.boot.gae.ecommercespa.dao;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.VoidWork;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.tyaa.java.spring.boot.gae.ecommercespa.util.CopyHelper;

/**
 *
 * @author student
 */
public abstract class AbstractObjectifyDAO<T> {
    private Class<T> entityType;

    public AbstractObjectifyDAO() {
        
        entityType =
            ((Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    
    public void create(T _entity) {
	
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                ofy().save().entity(_entity).now();
            }
        });
    }
    
    public void update(T _entity) {
	
        create(_entity);
    }
    
    public List<T> read() {
	
        List<T> entities = new ArrayList<>();
        
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                List<T> entitiesResult =
                    ofy().load().type(entityType).list();
                if (entitiesResult != null) {
                    entities.addAll(entitiesResult);
                }
            }
        });
        return entities;
    }
    
    public T read(Long _id)
            throws InstantiationException, IllegalAccessException {
            
        T entity = null;
        
            T finalEntity = entityType.newInstance();
            ObjectifyService.run(new VoidWork() {
                @Override
                public void vrun() {
                    T entityResult =
                        ofy().load().type(entityType).id(_id).now();
                    if (entityResult != null) {
                        CopyHelper.copy(entityResult, finalEntity);
                    }
                }
            });
            entity = finalEntity;
        return entity;
    }
    
    public void delete(Long _id) {
		
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                ofy().delete().type(entityType).id(_id).now();
            }
        });
    }
}
