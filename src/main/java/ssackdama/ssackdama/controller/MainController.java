package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.service.UserServiceImpl;

@Controller
public class MainController {
    @Autowired
    UserServiceImpl userServiceImpl;


    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("data","테스트 중");
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
    public String create(User user){
        userServiceImpl.join(user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginpage(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/login";
    }
    @PostMapping("/login")
    public String login(User user1){
        String email = user1.getEmail();
        String password = user1.getPassword();
        System.out.println("password"+password);
        if(userServiceImpl.login(email, password)){
            return "redirect:/";
        }else{
            return "pages/login";
        }
    }
    @GetMapping("/user")
    public String setting(Model model){
        return "pages/userInfo";
    }




}

