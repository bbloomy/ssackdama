package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AttributeOverride(name="id", column = @Column(name="ORDER_ID"))

public class Orders extends  BaseEntity{

     @ManyToOne
     //@JoinColumn(name="CUSTOMER_ID")
     @JoinColumn(name="user_id")
     private Customer customer;

     private Date orderDate;

    //@OneToMany(mappedBy = "orders")
    //private List<OrderDetail> orderItems=new ArrayList<>();
}
