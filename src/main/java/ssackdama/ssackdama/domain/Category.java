package ssackdama.ssackdama.domain;

import javax.persistence.*;

@Entity
//@AttributeOverride(name="id", column = @Column(name="CATEGORY_ID"))
public class Category extends BaseEntity{

    private String name;

    @OneToOne
    @JoinColumn(name="PARENT_ID")
    private Category parent;

}
