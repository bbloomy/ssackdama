package ssackdama.ssackdama.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ssackdama.ssackdama.domain.Member;

/*
 * 회원 가입
 * 회원 탈퇴
 * 로그인 / 로그아웃
 * */
public interface MemberService{

    // 회원 가입
    public boolean join(Member member);





    // 로그아웃
    public void logout(Member member);

    // 중복 회원
    public void validateDuplicateUser(Member member);


    // 회원 탈퇴
    public void resign(Member member);

}
