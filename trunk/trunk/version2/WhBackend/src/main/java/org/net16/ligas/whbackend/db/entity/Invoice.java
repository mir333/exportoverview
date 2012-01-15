package org.net16.ligas.whbackend.db.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


/**
 * @author xligas
 */
@Entity
public class Invoice extends AbstractDocument {
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceLine> invoiceLines;

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
}
