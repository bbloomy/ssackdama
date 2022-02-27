package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ssackdama.ssackdama.config.exceptions.BusinessException;
import ssackdama.ssackdama.config.exceptions.ErrorCode;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.repository.MemberRepository;


//PrincipalDetailsService
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean join(Member member) {
        boolean isSuccess=true;
        try{
            validateDuplicateUser(member);
            // 비밀번호 암호화
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
    public void withdrawal(String checkPassword) throws Exception{
        UserDetails loginedMember = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member omember=memberRepository.findOneByEmail(loginedMember.getUsername()).orElseThrow(()-> new Exception("회원이 존재하지 않습니다"));
        if(passwordEncoder.matches(checkPassword, omember.getPassword())){
            //storeRepository;

            memberRepository.deleteById(omember.getId());
            SecurityContextHolder.clearContext();
        }else{
            throw new BusinessException("비밀번호가 일치하지 않습니다.", ErrorCode.ENTITY_NOT_FOUND);
        }

    }

    @Override
    public void validateDuplicateUser(Member member) {
        memberRepository.findOneByEmail(member.getEmail())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    @Override
    public void updateUserInfo(Member member) {

    }

    @Override
    public void updatePassword(String oldPassword, String password, String passwordConfirm) {

    }
}
