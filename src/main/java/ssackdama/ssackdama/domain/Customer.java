package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User{

    /*귣아 필요없음. 왜? Order에서 찾을 수 있음.
    private List<Order> orders;*/
}
