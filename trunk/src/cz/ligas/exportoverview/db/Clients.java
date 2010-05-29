package cz.ligas.exportoverview.db;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author xligas
 */
@Entity
public class Clients extends AbstractUser {
    private static final long serialVersionUID = 1L;
    private Date editDate;
    private int total;
    private int totalSold;
    private int totalSent;
    private double totalSendValue;
    private double totalSoldValue;
    @OneToMany(mappedBy = "client")
    private List<Document> documents;
    @OneToMany(mappedBy="client")
    private List<ExportLine> exportLines;



    public Clients(){
        this.total=0;
        this.totalSendValue=0;
        this.totalSoldValue=0;
        this.totalSold=0;
        this.totalSent=0;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<ExportLine> getExportLines() {
        return exportLines;
    }

    public void setExportLines(List<ExportLine> exportLines) {
        this.exportLines = exportLines;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getTotalSendValue() {
        return totalSendValue;
    }

    public void setTotalSendValue(double totalSendValue) {
        this.totalSendValue = totalSendValue;
    }

    public int getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(int totalSent) {
        this.totalSent = totalSent;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public double getTotalSoldValue() {
        return totalSoldValue;
    }

    public void setTotalSoldValue(double totalSoldValue) {
        this.totalSoldValue = totalSoldValue;
    }
}
