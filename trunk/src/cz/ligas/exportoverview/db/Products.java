/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author xligas
 */
@Entity
@Table(name="PRODUCTS", schema = "APP")
public class Products implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private int id;
    private String productCode;
    private String productName;
    private float productPrice;
    private String productDes;
    @ManyToOne
    private ProductCategory productCategoryId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        String oldProductCode = this.productCode;
        this.productCode = productCode;
        changeSupport.firePropertyChange("productCode", oldProductCode, productCode);
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        String oldProductDes = this.productDes;
        this.productDes = productDes;
        changeSupport.firePropertyChange("productDes", oldProductDes, productDes);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        String oldProductName = this.productName;
        this.productName = productName;
        changeSupport.firePropertyChange("productName", oldProductName, productName);
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        float oldProductPrice = this.productPrice;
        this.productPrice = productPrice;
        changeSupport.firePropertyChange("productPrice", oldProductPrice, productPrice);
    }

    public ProductCategory getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ProductCategory productCategoryId) {
        ProductCategory oldProductCategoryId = this.productCategoryId;
        this.productCategoryId = productCategoryId;
        changeSupport.firePropertyChange("productCategoryId", oldProductCategoryId, productCategoryId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return productCode+ " " + productName +" "+productPrice ;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
