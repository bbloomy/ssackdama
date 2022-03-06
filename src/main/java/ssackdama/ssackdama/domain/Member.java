package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter@Setter@NoArgsConstructor
//@DiscriminatorColumn(name="role")
@Entity
@AttributeOverride(name="id", column = @Column(name="MEMBER_ID"))
public class Member extends BaseTimeEntity {
    @Column(name="email",nullable = false)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="username")
    private String username;


    @Column
    private String phonenumber="";

    @Embedded
    private Address addresses;
    //private String address="";

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Boolean enabled;

    @Column(name="password_changed_time")
    private Date passwordChangedTime;

    public Member(String email, String password, String username, Role role) {

        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member{email"+getEmail()+"password"+getPassword()+"username"+getUsername()+"phonenumber"+getPhonenumber()+"}";
    }
}
