package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@AttributeOverride(name="id", column = @Column(name="ORDER_ID"))

public class Orders extends  BaseEntity{

     @ManyToOne(fetch=FetchType.LAZY,optional = false)
     @JoinColumn(name="MEMBER_ID")//join한 컬럼의 pk의 이름을 users_id로 하겠다. User의 기본키랑 자동으로 매핑
     //만약, name을 작성하지 않는다면, 자동으로 table명_pk명 으로 join된다.
     private Member member;

     private Date orderDate;

    @OneToMany(mappedBy = "id",cascade=CascadeType.ALL ,orphanRemoval = true,fetch=FetchType.LAZY )
    private List<OrderDetail> orderItems=new ArrayList<>();
}
