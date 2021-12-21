package ssackdama.ssackdama.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")

public class Store {

    /*
        non-constant field name : lowerCamelCase
     */
    private int storeId;
    private int storeName;
    private Images storeImages;
    private String storeAddress;
    private int storePhoneNumber;

}
