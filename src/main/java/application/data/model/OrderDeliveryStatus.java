package application.data.model;

import javax.persistence.*;
import java.util.*;

@Table
@Entity(name = "dbo_order_delivery_status")
public class OrderDeliveryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_delivery_status_id")
    private int orderDeliveryStatusId;

    @ManyToMany
    @JoinTable(name = "dbo_order_product",
            joinColumns = @JoinColumn(name = "delivery_status_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orderList;

    @Column(name = "created_date")
    private Date createdDate;

    public int getOrderDeliveryStatusId() {
        return orderDeliveryStatusId;
    }

    public void setOrderDeliveryStatusId(int orderDeliveryStatusId) {
        this.orderDeliveryStatusId = orderDeliveryStatusId;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
