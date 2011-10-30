package org.net16.ligas.whbackend.db.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This entity represents categories of products.
 *
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory extends BaseEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable=false,unique=true)
    private String code;

    @Column(nullable=false)
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private List<Products> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
