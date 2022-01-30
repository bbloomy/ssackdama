package ssackdama.ssackdama.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssackdama.ssackdama.domain.Product;
import ssackdama.ssackdama.domain.Role;

import ssackdama.ssackdama.repository.ProductRepository;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void createProduct() throws Exception{
        //given

    }

}
