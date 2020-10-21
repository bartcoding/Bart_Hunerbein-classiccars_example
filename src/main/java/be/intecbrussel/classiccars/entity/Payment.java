package be.intecbrussel.classiccars.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "classicmodels", catalog = "")
public class Payment {
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;
    private Customer customer;

    @Id
    @Column(name = "checkNumber", nullable = false, length = 50)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Basic
    @Column(name = "paymentDate", nullable = false)
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(checkNumber, payment.checkNumber) &&
                Objects.equals(paymentDate, payment.paymentDate) &&
                Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkNumber, paymentDate, amount);
    }

    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
