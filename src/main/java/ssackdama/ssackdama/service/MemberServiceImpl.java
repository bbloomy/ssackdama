package ssackdama.ssackdama.service;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ssackdama.ssackdama.config.exceptions.*;

import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.repository.MemberRepository;

import java.util.Map;


//PrincipalDetailsService
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void join(Member member){
            validateDuplicateUser(member);
            // 비밀번호 암호화
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            // 로그인 했음^^
            member.setEnabled(true);
            memberRepository.save(member);

    }


    @Override
    public void withdrawal(String uncheked){
        UserDetails loginedMember = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member omember=memberRepository.findOneByEmail(loginedMember.getUsername()).orElseThrow(()-> new MemberNotFoundException("회원이 존재하지 않습니다"));
        checkPassword(uncheked,omember.getPassword());
        // 회원 삭제
        memberRepository.deleteById(omember.getId());
        SecurityContextHolder.clearContext();

    }

    @Override
    public void validateDuplicateUser(Member member) {
        memberRepository.findOneByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new EmailDuplicateException("회원가입에 실패하였습니다. 이미 가입되어 있습니다.");
                });
    }

    @Override
    public void updateUserInfo(Member member, Map<String, String[]> parameterMap) {
        System.out.println(parameterMap.get("phonenumber")[0]);
        if(!StringUtils.isNullOrEmpty(parameterMap.get("phonenumber")[0])){
            member.setPhonenumber(parameterMap.get("phonenumber")[0]);
        }

      memberRepository.save(member);
    }

    @Override
    public void updatePassword(Member member, String oldPassword, String password) {
        checkPassword(oldPassword,member.getPassword());
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
    }

    private void checkPassword(String inputPassword,String password){
        if(!passwordEncoder.matches(inputPassword,password)){
            throw new InvalidValueException("일치하는 회원을 찾을 수 없습니다.");
        }
    }
}
