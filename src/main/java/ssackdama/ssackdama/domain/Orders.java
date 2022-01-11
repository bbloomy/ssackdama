package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AttributeOverride(name="id", column = @Column(name="ORDER_ID"))

public class Orders extends  BaseEntity{

     @ManyToOne(fetch=FetchType.LAZY)
     //@JoinColumn(name="CUSTOMER_ID")
     @JoinColumn(name="user_id")
     private User user;

     private Date orderDate;

    //@OneToMany(mappedBy = "orders",fetch=FetchType.LAZY )
    //private List<OrderDetail> orderItems=new ArrayList<>();
}
