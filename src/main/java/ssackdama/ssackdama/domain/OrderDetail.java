package ssackdama.ssackdama.domain;

import javax.persistence.*;

@Entity
//@AttributeOverride(name="id", column = @Column(name="ORDER_DETAIL_ID"))

public class OrderDetail extends BaseEntity{

     @ManyToOne
     @JoinColumn(name="PRODUCT_ID")
     private Product product;

     @ManyToOne
     @JoinColumn(name="ORDER_ID")
     private Orders orders;

     private Integer quantity;
}
