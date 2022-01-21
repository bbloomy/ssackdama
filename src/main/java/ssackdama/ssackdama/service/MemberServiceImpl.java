package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ssackdama.ssackdama.config.SecurityMember;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.repository.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService {

    //@Autowired_ spring 4.3이상부터는 생성자가 하나인 경우 @Autowired를 사용하지 않아도 됨.
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean join(Member member) {
        boolean isSuccess=true;
        try{
            validateDuplicateUser(member);
            // 비밀번호 암호화
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
    public boolean login(String email, String password) {
        Member findMember = memberRepository.findByEmail(email);

        if(findMember ==null){
            return false;
        }else{
            System.out.println("DB in password : "+ findMember.getPassword());

            if(!findMember.getPassword().equals(passwordEncoder.encode(password))){
                //if(!findUser.getPassword().equals(password)){
                System.out.println("return false");
                return false;
            }
        }
        return true;
    }

    @Override
    public void resign(Member member) {

    }

    @Override
    public void logout(Member member) {

    }

    @Override
    public void validateDuplicateUser(Member member) {
        memberRepository.findOneByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //받은 유저 패스워드와 비교하여 로그인 인증
        Member member = memberRepository.findOneByEmail(username).get();
        return new SecurityMember(member);
    }
}
