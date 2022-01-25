package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.service.MemberServiceImpl;

@Controller
public class MainController {
    @Autowired
    MemberServiceImpl memberServiceImpl;


    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/index";
    }


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String create(Member member, Model model){
        System.out.println("user의 join: "+ member.getEmail());

        if(memberServiceImpl.join(member)){
            model.addAttribute("error","에러러");
            return "redirect:pages/login";
        }else{
            return "pages/signup";
        }

    }

    @GetMapping("/login")
    public String loginpage(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/login";
    }

    @GetMapping("/user")
    public String setting(Model model){
        return "pages/userInfo";
    }




}

