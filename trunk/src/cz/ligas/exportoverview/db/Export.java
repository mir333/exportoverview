/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.db;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author xligas
 */
@Entity
@Table(name = "EXPORT", schema = "APP")
public class Export implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date editDate;
    @ManyToOne
    private Clients client;
    @OneToMany(mappedBy = "export")
    private List<ExportLine> exportedProd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clients getKlient() {
        return client;
    }

    public void setKlient(Clients client) {
        this.client = client;
    }

    public List<ExportLine> getExportedProd() {
        return exportedProd;
    }

    public void setExportedProd(List<ExportLine> exportedProd) {
        this.exportedProd = exportedProd;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
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
        if (!(object instanceof Export)) {
            return false;
        }
        Export other = (Export) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
