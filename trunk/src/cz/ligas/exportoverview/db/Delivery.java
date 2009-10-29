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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author xligas
 */
@Entity
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Clients client;
    @OneToMany(mappedBy = "delivery")
    private List<ExportLine> expProd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public List<ExportLine> getExpProd() {
        return expProd;
    }

    public void setExpProd(List<ExportLine> expProd) {
        this.expProd = expProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.ligas.exportoverview.db.Delivery[id=" + id + "]";
    }

}
