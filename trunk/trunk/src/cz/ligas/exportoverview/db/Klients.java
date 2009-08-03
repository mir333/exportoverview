/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author xligas
 */
@Entity
@Table(name="KLIENTS", schema="APP" )
public class Klients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private int id;
    private String klientName;
    private String klientAddress;
    private String klientPhone;
    @OneToMany(mappedBy="klient")
    private List<Export> exports;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

       public String getKlientAddress() {
        return klientAddress;
    }

    public void setKlientAddress(String klientAddress) {
        this.klientAddress = klientAddress;
    }

    public String getKlientName() {
        return klientName;
    }

    public void setKlientName(String klientName) {
        this.klientName = klientName;
    }

    public String getKlientPhone() {
        return klientPhone;
    }

    public void setKlientPhone(String klientPhone) {
        this.klientPhone = klientPhone;
    }

    public List<Export> getExports() {
        return exports;
    }

    public void setExports(List<Export> exports) {
        this.exports = exports;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klients)) {
            return false;
        }
        Klients other = (Klients) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }

}
