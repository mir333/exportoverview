/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.db;

import java.io.Serializable;
import java.util.List;
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
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Clients client;
    @OneToMany(mappedBy = "invoice")
    private List<ExportLine> exportedProd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.ligas.exportoverview.db.Invoice[id=" + id + "]";
    }

}
