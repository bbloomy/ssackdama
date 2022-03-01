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

    @ManyToOne(optional = false) // optional false 햐면 연관된 엔티티가 항상 있어야 함.
    @JoinColumn(name="store_id")
    private Store store;

    @ManyToOne(optional = false)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

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
