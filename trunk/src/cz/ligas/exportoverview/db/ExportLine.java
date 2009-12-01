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
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author xligas
 */
@Entity
public class ExportLine implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable=false)
    private int sent;
    @Column(nullable=false)
    private int sold;
    @Column(nullable=false)
    private float  price;
    @Column(nullable=false)
    private float  sentPrice;
    @Column(nullable=false)
    private int total;
    @ManyToOne
    private Clients client;
    @OneToOne
    private Products prod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        int oldSent = this.sent;
        this.sent = sent;
        changeSupport.firePropertyChange("sent", oldSent, sent);
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        int oldSold = this.sold;
        this.sold = sold;
        changeSupport.firePropertyChange("sold", oldSold, sold);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSentPrice() {
        return sentPrice;
    }

    public void setSentPrice(float sentPrice) {
        this.sentPrice = sentPrice;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        Products oldProd = this.prod;
        this.prod = prod;
        changeSupport.firePropertyChange("prod", oldProd, prod);
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ExportLine)) {
            return false;
        }
        ExportLine other = (ExportLine) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+" "+sent+" "+sold+" "+total;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
