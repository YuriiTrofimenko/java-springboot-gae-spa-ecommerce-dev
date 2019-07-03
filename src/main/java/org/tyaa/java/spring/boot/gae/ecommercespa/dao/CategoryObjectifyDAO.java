package org.tyaa.java.spring.boot.gae.ecommercespa.dao;


import org.tyaa.java.spring.boot.gae.ecommercespa.entity.Role;
import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;
import com.googlecode.objectify.VoidWork;
import org.tyaa.java.spring.boot.gae.ecommercespa.util.CopyHelper;
import org.springframework.stereotype.Repository;
import org.tyaa.java.spring.boot.gae.ecommercespa.entity.Category;


/**
 *
 * @author yurii
 */
@Repository
public class CategoryObjectifyDAO extends AbstractObjectifyDAO<Category> {
    
    public Category read(String _name) throws Exception {
            
        Category categoryEntity = null;
        
            Category finalCategoryEntity = new Category();
            ObjectifyService.run(new VoidWork() {
                @Override
                public void vrun() {
                    Category categoryEntityResult =
                        ofy().load().type(Category.class)
                            .filter("name", _name)
                            .first()
                            .now();
                    if (categoryEntityResult != null) {
                        CopyHelper.copy(categoryEntityResult, finalCategoryEntity);
                    }
                }
            });
            categoryEntity = finalCategoryEntity;
            
        return categoryEntity;
    }
}