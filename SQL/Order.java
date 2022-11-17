package org.example;
import java.time.LocalDate;

public class Order {
    private int orderNumber;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippeDate;
    private String status;
    private String comments;
    private int customerNumber;

    public Order(int orderNumber, LocalDate orderDate, LocalDate requiredDate, LocalDate shippeDate, String status, String comments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippeDate = shippeDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public void setShippeDate(LocalDate shippeDate) {
        this.shippeDate = shippeDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public LocalDate getShippeDate() {
        return shippeDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippeDate=" + shippeDate +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customerNumber=" + customerNumber +
                '}';
    }
}
