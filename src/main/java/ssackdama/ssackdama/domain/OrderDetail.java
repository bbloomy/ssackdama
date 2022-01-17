package ssackdama.ssackdama.domain;

import javax.persistence.*;

@Entity
public class OrderDetail extends BaseEntity{

     @ManyToOne(fetch=FetchType.LAZY)//나중에 JPQL에서의 패치 조인 사용
     @JoinColumn(name="PRODUCT_ID")
     private Product product;

     @ManyToOne(fetch=FetchType.LAZY)//나중에 JPQL에서의 패치 조인 사용
     @JoinColumn(name="ORDER_ID")
     private Orders orders;

     private Integer quantity;
}
