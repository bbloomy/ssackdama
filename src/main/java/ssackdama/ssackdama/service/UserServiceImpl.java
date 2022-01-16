package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    //@Autowired_ spring 4.3이상부터는 생성자가 하나인 경우 @Autowired를 사용하지 않아도 됨.
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public void resign(User user) {

    }

    @Override
    public void login(String email, String password) {

    }

    @Override
    public void logout(User user) {

    }

}
