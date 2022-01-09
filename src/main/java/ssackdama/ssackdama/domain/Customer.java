package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer extends User{
    @Id
    @Column(name="CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*귣아 필요없음. 왜? Order에서 찾을 수 있음.
    private List<Order> orders;*/
}
