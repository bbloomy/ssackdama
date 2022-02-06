package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.service.StoreServiceImpl;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.service.MemberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Autowired
    StoreServiceImpl storeServiceImpl;

    @GetMapping("/")
    public String test(Model model){
        List<Store> storeList = storeServiceImpl.getAllStores();

        model.addAttribute("storeList",storeList);
        return "pages/index";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/index";
    }

    /*회원가입*/
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String create(Member member, Model model){
        System.out.println("user의 join: "+ member.getEmail());

        if(memberServiceImpl.join(member)){
            return "redirect:/login";
        }else{
            model.addAttribute("error","error");
            return "pages/signup";
        }

    }
    /*로그인_로그아웃*/
    @GetMapping("/login")
    public String loginpage(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    /*회원로그 내역*/
    @GetMapping("/info")
    public String setting(Model model){
        return "pages/info";
    }
    /*회원 정보*/
    @GetMapping("/userInfo")
    public String userInfo(Model model){
        return "pages/userInfo";
    }

    /*회원 탈퇴*/
    @GetMapping("/withdrawal")
    public String resignPage(){
        return "pages/withdrawal";
    }
    @PostMapping("/withdrawal")
    public String withdrawal(Member member, HttpSession session)throws Exception{

        return "redirect:/";
    }

}

