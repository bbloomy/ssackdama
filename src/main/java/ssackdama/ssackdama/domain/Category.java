package ssackdama.ssackdama.domain;

import javax.persistence.*;

@Entity
public class Category extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name="PARENT_ID")
    private Category parent;

}
