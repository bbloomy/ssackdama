package ssackdama.ssackdama.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssackdama.ssackdama.domain.Role;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void join() {
        //given
        User added=new User("3@gmail.com","password","user3", Role.CUSTOMER);
        System.out.println(added.toString());
        // 아래 save코드에서 nullpoint exception남
        userRepository.save(added);

        //when
        User user = userRepository.findOneByEmail("3@gmail.com");
        //then
        Assertions.assertThat(added.toString()).isEqualTo(user.toString());
    }
}