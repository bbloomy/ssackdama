package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
//@DiscriminatorColumn(name="role")
@Entity
@AttributeOverride(name="id", column = @Column(name="USER_ID"))

public class User extends BaseTimeEntity{
    @Column(name="email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="userName",nullable = false)
    private String userName;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Role role;

}
