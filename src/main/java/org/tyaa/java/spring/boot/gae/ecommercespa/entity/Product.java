package org.tyaa.java.spring.boot.gae.ecommercespa.entity;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.VoidWork;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import java.io.Serializable;
import org.tyaa.java.spring.boot.gae.ecommercespa.util.CopyHelper;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class Product implements Serializable {

    @Id
    private Long id;
    @Index
    private String title;
    private String description;
    @Index
    private Double price;
    @Index
    private int quantity;
    private String image;
    @Load
    @Index
    Ref<Category> category;

    public Product(String title, String description, Double price, int quantity, String image, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        setCategory(category);
    }

    public Product(Long id, String title, String description, Double price, int quantity, String image, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        setCategory(category);
    }
    
    

    // @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public final Category getCategory() {
        Category category = new Category();
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                Category categoryLocal = Product.this.category.get();
                if (categoryLocal != null) {
                    CopyHelper.copy(categoryLocal, category);
                }
            }
        });
        return category;
    }

    // @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public final void setCategory(Category category) {
        ObjectifyService.run(new VoidWork() {
            @Override
            public void vrun() {
                Product.this.category = Ref.create(category);
            }
        });
    }
}
