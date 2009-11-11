package cz.ligas.exportoverview.db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author xligas
 */
@Entity
@Table(name="CLIENTS", schema="APP" )
public class Clients implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(name = "C_NAME", nullable = false)
    private String clientName;
    private String clientAddress;
    private String psc;
    private String city;
    private String country;
    private String ico;
    private String dic;
    private String clientPhone;
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;
    @OneToMany(mappedBy = "client")
    private List<Delivery> deliveries;
    @OneToMany(mappedBy="client")
    private List<Export> exports;

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        String oldClientAddress = this.clientAddress;
        this.clientAddress = clientAddress;
        changeSupport.firePropertyChange("clientAddress", oldClientAddress, clientAddress);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        String oldClientName = this.clientName;
        this.clientName = clientName;
        changeSupport.firePropertyChange("clientName", oldClientName, clientName);
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        String oldClientPhone = this.clientPhone;
        this.clientPhone = clientPhone;
        changeSupport.firePropertyChange("clientPhone", oldClientPhone, clientPhone);
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id +" "+ clientName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}