package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.config.auth.PrincipalDetails;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.repository.MemberRepository;

//PrincipalDetailsService
@Service
public class MemberServiceImpl implements MemberService , UserDetailsService {

    //@Autowired_ spring 4.3이상부터는 생성자가 하나인 경우 @Autowired를 사용하지 않아도 됨.
    @Autowired
    private MemberRepository memberRepository;


    @Override
    //.usernameParameter()랑 파라미터 프론트랑 맞춰야 함.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("으악으악"+email);
        //받은 유저 패스워드와 비교하여 로그인 인증
        Member member=memberRepository.findByEmail(email);

        if(member==null){
            System.out.println("으악으악으악");
            throw new UsernameNotFoundException(email);
        }
        return new PrincipalDetails(member);//시큐리티 세션(내부 Authentication(내부 UserDetails))

    }
    @Override
    public boolean join(Member member) {
        boolean isSuccess=true;
        try{
            validateDuplicateUser(member);
            // 비밀번호 암호화
            BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            // 로그인 했음^^
            member.setEnabled(true);
            System.out.println("user의 join"+ member.getEmail());
            memberRepository.save(member);
        }catch (IllegalStateException e){
            isSuccess=false;
        }finally {
            return isSuccess;
        }
    }


    @Override
    public void resign(Member member) {

    }



    @Override
    public void validateDuplicateUser(Member member) {
        memberRepository.findOneByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }



}
