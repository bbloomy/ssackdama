package ssackdama.ssackdama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {
    @GetMapping("/manage")
    public String search(){
        return "pages/product_add";
    }
}
