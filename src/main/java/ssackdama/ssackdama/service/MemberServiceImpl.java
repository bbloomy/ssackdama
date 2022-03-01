package ssackdama.ssackdama.service;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ssackdama.ssackdama.config.exceptions.EmailDuplicateException;

import ssackdama.ssackdama.config.exceptions.EntityNotFoundException;
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
    public void join(Member member) throws Exception {
            validateDuplicateUser(member);
            // 비밀번호 암호화
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            // 로그인 했음^^
            member.setEnabled(true);
            memberRepository.save(member);

    }


    @Override
    public void withdrawal(String checkPassword) throws Exception{
        UserDetails loginedMember = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member omember=memberRepository.findOneByEmail(loginedMember.getUsername()).orElseThrow(()-> new EntityNotFoundException("회원이 존재하지 않습니다"));
        if(!passwordEncoder.matches(checkPassword, omember.getPassword())){
            throw new EntityNotFoundException("일치하는 회원을 찾을 수 없습니다.", ErrorCode.MEMBER_NOT_FOUND);
        }
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
    public void updateUserInfo(Member member) {

    }

    @Override
    public void updatePassword(String oldPassword, String password, String passwordConfirm) {

    }
}
