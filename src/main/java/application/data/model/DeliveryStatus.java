package application.data.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "dbo_delivery_status")
public class DeliveryStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "delivery_status_id")
    private int deliveryStatusId;

    @ManyToMany
    @JoinTable(name = "dbo_order_product",
            joinColumns = @JoinColumn(name = "delivery_status_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orderList;

    @Column(name = "name")
    private String name;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(int deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
