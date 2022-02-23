package ssackdama.ssackdama.service;

import ssackdama.ssackdama.domain.Member;

/*
 * 회원 가입
 * 회원 탈퇴
 * 로그인 / 로그아웃
 * */
public interface MemberService{

    // 회원 가입
    public void join(Member member) throws Exception;

    // 회원 정보 수정
    void updateUserInfo(Member member);


    // 중복 회원
    public void validateDuplicateUser(Member member);


    // 회원 탈퇴
    void withdrawal(String checkPassword) throws Exception;

    void updatePassword(String oldPassword, String password, String passwordConfirm);
}
