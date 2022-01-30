package ssackdama.ssackdama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.service.ProductServiceImpl;

@Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @GetMapping("/product/detail")
    public String ProductDetail(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/detail";
    }

    @GetMapping("/product/add")
    public String ProductAdd(Model model){

        return "pages/product_add";
    }
    @PostMapping("/product/add")
    public String ProductAdd(Model model, Store store){
        System.out.println("Store: "+ store);
        if(productServiceImpl.addProduct(store)){
            System.out.println("Product Add Success");
        }else{
            System.out.println("Product Add Fail");
        }
        return "pages/detail";
    }



    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("data","테스트 중");
        return "pages/search";
    }
}
