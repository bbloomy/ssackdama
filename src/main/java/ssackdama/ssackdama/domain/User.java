package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter@Setter@NoArgsConstructor

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

    //@Embedded
    //private Address address;
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String email, String password, String userName, Role role) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }

}
