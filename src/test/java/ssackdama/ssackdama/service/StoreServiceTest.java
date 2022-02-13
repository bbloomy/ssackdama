package ssackdama.ssackdama.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.repository.StoreRepository;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class StoreServiceTest {

    @Autowired
    StoreService storeService;
    @Autowired
    private StoreRepository storeRepository;


    @Test
    public void getStores() throws Exception{
        List<Store> storeList = storeRepository.findAll();
        System.out.println("storeList :"+ storeList.get(0).getId());

    }


}
