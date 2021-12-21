package ssackdama.ssackdama.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DateTimeException;
import java.util.Date;


@Entity
@Table(name = "likes")

public class Like extends BaseEntity{

    private Product store;
    private User user;
    private Date expireDate;

}
