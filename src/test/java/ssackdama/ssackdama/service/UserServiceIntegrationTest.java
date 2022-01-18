package ssackdama.ssackdama.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssackdama.ssackdama.domain.Role;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;

import javax.transaction.Transactional;

import java.rmi.MarshalException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class UserServiceIntegrationTest {
    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void join() throws Exception{
        //given
        User added=new User("1@gmail.com","password","user1", Role.CUSTOMER);
        userService.join(added);
        //when
        User user = userRepository.findOneByEmail("1@gmail.com").get();

        //then
        Assertions.assertThat(added.toString()).isEqualTo(user.toString());
    }
    @Test
    public void duplicate_user_exception() throws Exception{
        //Given
        User user = new User("2@gmail.com","password","user2", Role.CUSTOMER);
        User user2 = new User("2@gmail.com","password","user2", Role.CUSTOMER);
        //when
        userService.join(user);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(user2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}