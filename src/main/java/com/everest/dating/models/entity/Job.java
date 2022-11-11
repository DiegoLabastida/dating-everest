package com.everest.dating.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Description Name may not be NULL")
    private String description;

    @NotEmpty(message = "Price Name may not be NULL")
    private double price;

    @Column(nullable = true)
    private boolean paid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @NotEmpty(message = "Contract Id may not be NULL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Contract.class)
    private Contract contract;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContractId(Contract contract) {
        this.contract = contract;
    }
}
