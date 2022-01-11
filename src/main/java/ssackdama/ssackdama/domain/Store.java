package ssackdama.ssackdama.domain;


import javax.persistence.*;

@Entity
@AttributeOverride(name="id", column = @Column(name="STORE_ID"))

public class Store extends BaseEntity{

    /*
        non-constant field name : lowerCamelCase
     */

    private int storeName;
    private Images storeImages;
    private Address storeAddress;
    private int storePhoneNumber;

}
