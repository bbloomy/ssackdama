package ssackdama.ssackdama.service;

import ssackdama.ssackdama.domain.User;

/*
 * 회원 가입
 * 회원 탈퇴
 * 로그인 / 로그아웃
 * */
public interface MemberServiceImpl {

    // 회원 가입
    public Long join(User user);

    // 회원 탈퇴
    public void resign(User user);

    //
}
