package cz.ligas.exportoverview.db;

import javax.persistence.Entity;


/**
 *
 * @author xligas
 */
@Entity
public class UserInfo extends AbstractUser {
    private static final long serialVersionUID = 1L;

    private String bank;
    private String bankNo;
    private String isban;
    private String swift;
    private int deliverCount;
    private int invoiceCount;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public int getDeliverCount() {
        return deliverCount;
    }

    public void setDeliverCount(int deliverCount) {
        this.deliverCount = deliverCount;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public void setInvoiceCount(int invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    public String getIsban() {
        return isban;
    }

    public void setIsban(String isban) {
        this.isban = isban;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

}