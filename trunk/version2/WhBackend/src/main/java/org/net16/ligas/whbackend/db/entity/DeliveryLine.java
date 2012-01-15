package org.net16.ligas.whbackend.db.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author xligas
 */
@Entity
public class DeliveryLine extends AbstractDocumentLine {
    @ManyToOne
    private Delivery delivery;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
