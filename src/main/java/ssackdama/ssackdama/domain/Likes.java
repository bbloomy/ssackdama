package ssackdama.ssackdama.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;


@Entity
public class Likes extends BaseEntity{

    private Product store;
    private User user;
    private Date expireDate;


}
