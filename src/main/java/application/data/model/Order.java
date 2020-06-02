package application.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity(name = "dbo_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "guid")
    private String guid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "delivery_status_id")
    private int deliveryStatusId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderDeliveryStatus> orderDeliveryStatusList = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderProduct> orderProductList = new ArrayList<>();


    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;


    @Column(name = "price")
    private Double price;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "ship")
    private Double ship;

    public int getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(int deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    public List<OrderDeliveryStatus> getOrderDeliveryStatusList() {
        return orderDeliveryStatusList;
    }

    public void setOrderDeliveryStatusList(List<OrderDeliveryStatus> orderDeliveryStatusList) {
        this.orderDeliveryStatusList = orderDeliveryStatusList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getShip() {
        return ship;
    }

    public void setShip(Double ship) {
        this.ship = ship;
    }
}
