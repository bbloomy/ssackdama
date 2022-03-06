package ssackdama.ssackdama.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter @Setter
@Embeddable@NoArgsConstructor
public class Address{

    private String zonecode,address,detail_address;

    public Address(String zonecode, String address, String detail_address) {
        this.zonecode = zonecode;
        this.address = address;
        this.detail_address = detail_address;
    }
}
