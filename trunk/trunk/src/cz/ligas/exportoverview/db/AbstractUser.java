package cz.ligas.exportoverview.db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author xligas
 */
@Entity
public class AbstractUser implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private int id;
    @Column(nullable = false)
    private String clientName;
    private String company;
    private String clientAddress;
    private String psc;
    private String city;
    private String country;
    private String ico;
    private String dic;
    private String clientPhone;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        String oldClientPhone = this.clientPhone;
        this.clientPhone = clientPhone;
        changeSupport.firePropertyChange("clientPhone", oldClientPhone, clientPhone);
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
        if (!(object instanceof AbstractUser)) {
            return false;
        }
        AbstractUser other = (AbstractUser) object;
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
