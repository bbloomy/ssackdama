package ssackdama.ssackdama.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
//@AttributeOverride(name="id", column = @Column(name="PRODUCT_ID"))

public class Product extends BaseEntity {

    private Store store;
    private String name;
    private int price;
    private String about;
    private int categoryId;
    private int discountPrice;
    private int stockNum;
    private Date createDate;
    private Date expireDate;

}
