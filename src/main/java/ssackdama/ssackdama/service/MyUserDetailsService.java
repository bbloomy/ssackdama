package ssackdama.ssackdama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssackdama.ssackdama.config.auth.PrincipalDetails;
import ssackdama.ssackdama.config.exceptions.EntityNotFoundException;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.repository.MemberRepository;

@Service
@Transactional

public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    //.usernameParameter()랑 파라미터 프론트랑 맞춰야 함.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //받은 유저 패스워드와 비교하여 로그인 인증
        Member member=memberRepository.findOneByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email));

        return new PrincipalDetails(member);//시큐리티 세션(내부 Authentication(내부 UserDetails))

    }
}
