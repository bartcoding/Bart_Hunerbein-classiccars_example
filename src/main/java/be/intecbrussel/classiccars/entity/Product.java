package be.intecbrussel.classiccars.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "classicmodels", catalog = "")
public class Product {
    private String productCode;
    private String productName;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
    private Productline productline;

    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "productName", nullable = false, length = 70)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "productScale", nullable = false, length = 10)
    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Basic
    @Column(name = "productVendor", nullable = false, length = 50)
    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Basic
    @Column(name = "productDescription", nullable = false, length = -1)
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "quantityInStock", nullable = false)
    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Basic
    @Column(name = "buyPrice", nullable = false, precision = 2)
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Basic
    @Column(name = "MSRP", nullable = false, precision = 2)
    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantityInStock == product.quantityInStock &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productScale, product.productScale) &&
                Objects.equals(productVendor, product.productVendor) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(buyPrice, product.buyPrice) &&
                Objects.equals(msrp, product.msrp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
    }

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine", nullable = false)
    public Productline getProductline() {
        return productline;
    }

    public void setProductline(Productline productline) {
        this.productline = productline;
    }
}
