package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.persistence.*;

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
    //@Embedded
    //private Address address;
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Boolean enabled;

    public Member(String email, String password, String username, Role role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }

}
