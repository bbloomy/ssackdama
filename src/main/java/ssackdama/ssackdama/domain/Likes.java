package ssackdama.ssackdama.domain;

import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Likes extends BaseEntity{

    private Product store;
    private Member member;
    private Date expireDate;


}
