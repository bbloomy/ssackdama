package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private MemberRepository memberRepository;


    @Override
    //.usernameParameter()랑 파라미터 프론트랑 맞춰야 함.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //받은 유저 패스워드와 비교하여 로그인 인증
        Member member=memberRepository.findByEmail(email);

        if(member==null){
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

            memberRepository.save(member);
        }catch (IllegalStateException e){
            isSuccess=false;
        }finally {
            return isSuccess;
        }
    }



    @Override
    public void withdraw(String checkPassword) throws Exception{
        UserDetails loginedMember = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member omember=memberRepository.findOneByEmail(loginedMember.getUsername()).orElseThrow(()-> new Exception("회원이 존재하지 않습니다"));
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        if(passwordEncoder.matches(checkPassword, omember.getPassword())){
            memberRepository.deleteById(omember.getId());
            SecurityContextHolder.clearContext();
        }else{
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

    }



    @Override
    public void validateDuplicateUser(Member member) {
        memberRepository.findOneByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }



}
