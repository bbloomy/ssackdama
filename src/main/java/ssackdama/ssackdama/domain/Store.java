package ssackdama.ssackdama.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stores")

public class Store extends BaseEntity{

    /*
        non-constant field name : lowerCamelCase
     */
    private int storeName;
    private Images storeImages;
    private String storeAddress;
    private int storePhoneNumber;

}
