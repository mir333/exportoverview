package org.net16.ligas.whbackend.db.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Miroslav Ligas <miroslav.ligas@gmail.com>
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String clientName;
    private String company;
    @OneToOne //TODO: replace with map
    private Address address;
    private String ico;
    private String dic;
    private String clientPhone; //TODO: replace with list

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Delivery> deliveries;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Invoice> invoices;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<ExportLine> exportLines;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<ExportLine> getExportLines() {
        return exportLines;
    }

    public void setExportLines(List<ExportLine> exportLines) {
        this.exportLines = exportLines;
    }
}
