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
    @ManyToOne( optional = false) // optional false 또는 nullable false이면 member없이 store생성 불가
    @JoinColumn(name="MEMBER_ID")
    //만약, name을 작성하지 않는다면, 자동으로 table명_pk명 으로 join된다.
    private Member member;

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
