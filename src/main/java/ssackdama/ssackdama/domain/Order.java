package ssackdama.ssackdama.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="orders")
public class Order extends  BaseEntity{
    @Column(name="customer")
    private Customer customer;
    @Column
    private Date orderDate;
    @Column
    private List<OrderDetail> orders;
}
