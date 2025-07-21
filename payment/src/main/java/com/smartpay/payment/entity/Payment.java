package com.smartpay.payment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payment", indexes = {
    @Index(name = "idx_sender_account", columnList = "sender_account_id"),
    @Index(name = "idx_receiver_account", columnList = "receiver_account_id"),
    @Index(name = "idx_payment_date", columnList = "payment_date")
})
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @NotNull
    @Column(name = "sender_account_id", nullable = false)
    private Long senderAccountId;

    @NotNull
    @Column(name = "receiver_account_id", nullable = false)
    private Long receiverAccountId;

    /*
    Many payments can belong to the same sender or receiver account.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account senderAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private Account receiverAccount;
     */

    @NotNull
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "payment_date", insertable = false, updatable = false)
    private Timestamp paymentDate;

    @Size(max = 20)
    @Column(name = "payment_status")
    private String paymentStatus;

    @Size(max = 255)
    private String remarks;

    // Optional: auto set timestamp if Hibernate doesn't insert it from DB
    @PrePersist
    protected void onCreate() {
        if (paymentDate == null) {
            paymentDate = new Timestamp(System.currentTimeMillis());
        }
    }

    // Getters and Setters
    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getSenderAccountId() { return senderAccountId; }
    public void setSenderAccountId(Long senderAccountId) { this.senderAccountId = senderAccountId; }

    public Long getReceiverAccountId() { return receiverAccountId; }
    public void setReceiverAccountId(Long receiverAccountId) { this.receiverAccountId = receiverAccountId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Timestamp getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Timestamp paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
