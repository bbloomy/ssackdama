package ssackdama.ssackdama.domain;

import javax.persistence.*;
import java.util.List;

@Entity

public class Customer extends User{
    public Customer(String email, String password, String userName, Role role) {
        super(email, password, userName, role);
    }

    /*귣아 필요없음. 왜? Order에서 찾을 수 있음.
    private List<Order> orders;*/
}
