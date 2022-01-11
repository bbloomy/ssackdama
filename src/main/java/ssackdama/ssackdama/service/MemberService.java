package ssackdama.ssackdama.service;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.domain.Customer;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    @Autowired
    private final UserRepository userRepository;

    public boolean login(User user1) {
        Optional<Customer> findUser = userRepository.findByEmail(user1.getEmail());
        if(findUser == null){
            return false;
        }
//        if(!findUser.getpassword().equals(user.getPassword())){
//            return false;
//        }
        return true;
//        log.info("db password = {}, input password = {}", user.get().getPassword(), password);
//        if(user.get().getPassword().equals(password)) {
//            return "Success";
//        }
//        return "Failed";
    }
}
