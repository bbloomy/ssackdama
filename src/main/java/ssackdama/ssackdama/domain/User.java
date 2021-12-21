package ssackdama.ssackdama.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class User extends BaseEntity{
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="userName")
    private String userName;

    @Column(name="address")
    private String address;

    @Column(name="joinDate")
    private Date joinDate;
}
