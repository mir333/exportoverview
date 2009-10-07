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
import javax.persistence.Transient;

/**
 *
 * @author xligas
 */
@Entity
public class WarehouseItem implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int productCount;
    @ManyToOne
    private Products productItem;
//    @ManyToOne
//    private Warehouse warehouse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        int oldProductCount = this.productCount;
        this.productCount = productCount;
        changeSupport.firePropertyChange("productCount", oldProductCount, productCount);
    }

    public Products getProductItem() {
        return productItem;
    }

    public void setProductItem(Products productItem) {
        Products oldProductItem = this.productItem;
        this.productItem = productItem;
        changeSupport.firePropertyChange("productItem", oldProductItem, productItem);
    }

//    public Warehouse getWarehouse() {
//        return warehouse;
//    }
//
//    public void setWarehouse(Warehouse warehouse) {
//        Warehouse oldWarehouse = this.warehouse;
//        this.warehouse = warehouse;
//        changeSupport.firePropertyChange("warehouse", oldWarehouse, warehouse);
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehouseItem)) {
            return false;
        }
        WarehouseItem other = (WarehouseItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+"";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
