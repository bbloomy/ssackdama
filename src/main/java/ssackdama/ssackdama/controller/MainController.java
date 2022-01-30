package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.service.StoreServiceImpl;
import ssackdama.ssackdama.domain.Member;
import ssackdama.ssackdama.service.MemberServiceImpl;

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


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/signup";
    }

    @PostMapping("/signup")
    public String create(Member member, Model model){
        System.out.println("user의 join: "+ member.getEmail());

        if(memberServiceImpl.join(member)){
            return "redirect:/pages/login";
        }else{
            model.addAttribute("error","error");
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

