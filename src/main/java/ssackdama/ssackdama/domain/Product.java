package ssackdama.ssackdama.domain;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "product")

public class Product extends BaseEntity {

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
