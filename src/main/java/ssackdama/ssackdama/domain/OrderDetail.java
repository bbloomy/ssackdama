package ssackdama.ssackdama.domain;

import javax.persistence.*;

@Entity
public class OrderDetail extends BaseEntity{
     @Id
     @GeneratedValue
     @Column(name="ORDER_DETAIL_ID")
     private Long id;

     @ManyToOne
     @JoinColumn(name="PRODUCT_ID")
     private Product product;

     @ManyToOne
     @JoinColumn(name="ORDER_ID")
     private Orders orders;

     private Integer quantity;
}
