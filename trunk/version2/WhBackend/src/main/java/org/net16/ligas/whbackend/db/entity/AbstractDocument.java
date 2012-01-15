package org.net16.ligas.whbackend.db.entity;

import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author xligas
 */

public abstract class AbstractDocument extends BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(value = TemporalType.DATE)
    private Date createDate;

    @Temporal(value = TemporalType.DATE)
    private Date editDate;

    private int docNumber;

    private boolean archived;

    @ManyToOne
    private Customer customer;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
