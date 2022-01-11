package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
@DiscriminatorColumn(name="role")
@Entity

public class User extends BaseEntity{
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email",nullable = false)
    private Email email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="userName",nullable = false)
    private String userName;

    @Embedded
    private Address address;

    @Column(name="joinDate",nullable = false)
    private Date joinDate;
}
