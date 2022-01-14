package ssackdama.ssackdama.service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;


@Service
public class MemberService implements MemberServiceImpl {

    @Autowired
    private final UserRepository userRepository;

    public MemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public Long join(User user) {
        userRepository.save(user);
        return null;
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
