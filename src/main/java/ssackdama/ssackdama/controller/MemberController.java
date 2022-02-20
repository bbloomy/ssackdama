package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ssackdama.ssackdama.config.auth.PrincipalDetails;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.service.MemberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {
    @Autowired
    MemberServiceImpl memberServiceImpl;


    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/index";
    }

    /*회원가입*/
    @GetMapping("/signup")
    public String signup(Model model){
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String create(Member member){
        if(memberServiceImpl.join(member)){
            return "redirect:/login";
        }else{
            return "redirect:/signup?error";
        }

    }
    /*로그인_로그아웃*/
    @GetMapping("/login")
    public String loginpage(){
        return "pages/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    /*구매자 회원 - 찜한 가게 / 찜한 상품
    * 판매자 회원 - 운영중인 store */
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/info")
    public String setting(){
        return "pages/info";
    }


    @PreAuthorize("hasRole('ROLE_SELLER')")
    @GetMapping("/info-seller")
    public String customer_info(){
        return "pages/info_seller";
    }//sec:authentication="name


    /*회원 정보*/
    @GetMapping("/userInfo")
    public String userInfo(@AuthenticationPrincipal PrincipalDetails userDetails,Model model){
        //user.getMember()
        model.addAttribute("member",userDetails.getMember());
        return "pages/userInfo";
    }

    @PostMapping("/userInfo")
    /*이름 전화번호 주소 따로 만들기 vs dynamicUpdate*/
    public String userInfo_edit(@AuthenticationPrincipal PrincipalDetails userDetails,Member member){//@RequestBody->
        System.out.println("!!!!controller!!!!!"+member.getEmail());
        memberServiceImpl.updateUserInfo(member);
        return "redirect:/userInfo";
    }
    @PostMapping("/password")
    /*비밀번호!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    public void password_edit(HttpServletRequest request, HttpServletResponse response,
                              Model model, RedirectAttributes ra,
                              @AuthenticationPrincipal PrincipalDetails userDetails){
        Member member = userDetails.getMember();

        String oldPassword = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String newPasswordCheck = request.getParameter("newPasswordCheck");




    }

    /*회원 탈퇴*/
    @GetMapping("/withdrawal")
    public String resignPage(){
        return "pages/withdrawal";
    }

    @PostMapping("/withdrawal")
    public String withdrawal(Member member, HttpSession session)throws Exception{
        memberServiceImpl.withdraw(member.getPassword());
        return "redirect:/";
    }
    /*비밀번호 재설정*/
    @GetMapping("/password-reset")
    public String resetPassword(){
        return "pages/password_reset";

    }


}

