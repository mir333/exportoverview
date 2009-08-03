/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author xligas
 */
@Entity
public class ExportLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int sent;
    private int sold;
    @ManyToOne
    private Export export;
    @ManyToOne
    private Products prod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Export getExport() {
        return export;
    }

    public void setExport(Export export) {
        this.export = export;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
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
        return "test.ExportLine[id=" + id + "]";
    }
}
