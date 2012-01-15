package org.net16.ligas.whbackend.db.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author xligas
 */
@Entity
public class InvoiceLine extends AbstractDocumentLine {
    @ManyToOne
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
