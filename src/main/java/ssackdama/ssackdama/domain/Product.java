package ssackdama.ssackdama.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
//@AttributeOverride(name="id", column = @Column(name="PRODUCT_ID"))

public class Product extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="store_id")
    private Store store;

    @Column(name="productName")
    private String productName;

    @Column(name="productPrice")
    private int productPrice;

    @Column(name="productAbout")
    private String productAbout;

    @Column(name="categoryId")
    private int categoryId;

    @Column(name="discountPrice")
    private int discountPrice;

    @Column(name="stockNum")
    private int stockNum;

    @Column(name="createDate")
    private Date createDate;

    @Column(name="expireDate")
    private Date expireDate;

}
