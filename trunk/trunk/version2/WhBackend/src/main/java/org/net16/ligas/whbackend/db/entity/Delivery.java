package org.net16.ligas.whbackend.db.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author xligas
 */
@Entity
public class Delivery extends AbstractDocument {
    @OneToMany(mappedBy = "delivery")
    private List<DeliveryLine> deliveryLie;

    public List<DeliveryLine> getDeliveryLie() {
        return deliveryLie;
    }

    public void setDeliveryLie(List<DeliveryLine> deliveryLie) {
        this.deliveryLie = deliveryLie;
    }
}
