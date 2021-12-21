package ssackdama.ssackdama.domain;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class User extends BaseEntity{
    private String email;
    private String password;
    private String userName;
    private String address;
    private Date joinDate;

}
