package ssackdama.ssackdama.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="sellers")
public class Seller extends User{
    public Seller(String email, String password, String userName, Role role) {
        super(email, password, userName, role);
    }
//나중에 store찾기 위한 list하나 만들기
}
