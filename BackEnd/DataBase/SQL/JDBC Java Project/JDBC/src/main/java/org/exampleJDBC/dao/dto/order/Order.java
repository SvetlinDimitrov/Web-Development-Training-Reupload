package org.exampleJDBC.dao.dto.order;

import org.exampleJDBC.dao.dto.DataTransferObject;

import java.math.BigDecimal;

public class Order implements DataTransferObject {
    private Long id;
    private String date;
    private BigDecimal total;
    private String status;
    private Integer quantity;

    private CustomOrder customer;
    private ProductOrder product;
    private SalesmanOrder salesman;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CustomOrder getCustomer() {
        return customer;
    }

    public void setCustomer(CustomOrder customer) {
        this.customer = customer;
    }

    public ProductOrder getProduct() {
        return product;
    }

    public void setProduct(ProductOrder product) {
        this.product = product;
    }

    public SalesmanOrder getSalesman() {
        return salesman;
    }

    public void setSalesman(SalesmanOrder salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\n' +
                ", date='" + date + '\n' +
                ", total=" + total + '\n' +
                ", status='" + status + '\n' +
                ", quantity=" + quantity + '\n' +
                ", customer=" + customer.toString() + '\n' +
                ", product=" + product.toString() + '\n' +
                ", salesman=" + salesman.toString() + '\n' +
                '}';
    }
}
