package ssackdama.ssackdama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @GetMapping("/detail")
    public String ProductDetail(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/detail";
    }

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/search";
    }
}
