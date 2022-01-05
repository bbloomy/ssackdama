package ssackdama.ssackdama.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

//@Entity
//@Table(name="customers")
public class Customer extends User{
    //귣아 필요없음. 왜? Order에서 찾을 수 있음.
    //private List<Order> orders;
}
