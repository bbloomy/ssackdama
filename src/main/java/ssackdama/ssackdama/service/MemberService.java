package ssackdama.ssackdama.service;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.repository.UserRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private final UserRepository userRepository;

    public MemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(User user1) {

        return true;

    }
}
