package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders extends  BaseEntity{
     @Id @GeneratedValue
     @Column(name="ORDER_ID")
     private Long id;

     @ManyToOne
     @JoinColumn(name="CUSTOMER_ID")
     private Customer customer;

     private Date orderDate;

    //@OneToMany(mappedBy = "orders")
    //private List<OrderDetail> orderItems=new ArrayList<>();
}
