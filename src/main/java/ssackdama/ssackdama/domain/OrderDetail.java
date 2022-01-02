package ssackdama.ssackdama.domain;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;

public class OrderDetail {
    @Column
    private Product product;
    @Column
    private Integer quantity;
}
