package ssackdama.ssackdama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.User;
import ssackdama.ssackdama.service.UserServiceImpl;

@Controller
public class ProductController {

//    @Autowired
//    UserServiceImpl userServiceImpl;
    @GetMapping("/detail")
    public String ProductDetail(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/detail";
    }


}
