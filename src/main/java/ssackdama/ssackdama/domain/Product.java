package ssackdama.ssackdama.domain;


import javax.persistence.*;
import java.util.Date;

@Entity

public class Product extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="PRODUCT_ID")
    private Long id;

    private Store store;
    private String name;
    private int price;
    private String about;
    private int categoryId;
    private int discountPrice;
    private int stockNum;
    private Date createDate;
    private Date ExpireDate;

}
