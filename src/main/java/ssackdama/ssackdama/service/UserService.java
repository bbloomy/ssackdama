package ssackdama.ssackdama.service;

import org.springframework.ui.Model;
import ssackdama.ssackdama.domain.User;

import javax.servlet.http.HttpServletRequest;

/*
 * 회원 가입
 * 회원 탈퇴
 * 로그인 / 로그아웃
 * */
public interface UserService {

    // 회원 가입
    public void join(User user);

    // 회원 탈퇴
    public void resign(User user);

    // 로그인
    public boolean login(String email, String password);

    // 로그아웃
    public void logout(User user);

}
