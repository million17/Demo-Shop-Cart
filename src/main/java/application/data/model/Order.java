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
    private int phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
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




}
