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

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_status_id")
    private DeliveryStatus deliveryStatus;

    @Column(name = "created_date")
    private Date createdDate;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getOrderDeliveryStatusId() {
        return orderDeliveryStatusId;
    }

    public void setOrderDeliveryStatusId(int orderDeliveryStatusId) {
        this.orderDeliveryStatusId = orderDeliveryStatusId;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
