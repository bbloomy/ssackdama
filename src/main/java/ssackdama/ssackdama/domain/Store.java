package ssackdama.ssackdama.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@AttributeOverride(name="id", column = @Column(name="STORE_ID"))


public class Store extends BaseEntity{

    /*
        non-constant field name : lowerCamelCase
     */
    @Column(name="storeName")
    private String storeName;

    @Column(name="storeDetail")
    private String storeDetail;

    @Column(name="storeImages")
    private Images storeImages;

    @Column(name="storeAddress")
    private Address storeAddress;

    @Column(name="storePhoneNumber")
    private Integer storePhoneNumber;

}
