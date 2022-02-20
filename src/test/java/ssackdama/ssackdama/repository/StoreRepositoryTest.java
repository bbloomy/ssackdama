package ssackdama.ssackdama.repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.domain.Role;
import ssackdama.ssackdama.repository.StoreRepository;

import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
public class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;
    @Test
    public void snackTest() {
        System.out.println(storeRepository.findByUser(1L));
    }



}
