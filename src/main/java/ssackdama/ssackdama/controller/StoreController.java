package ssackdama.ssackdama.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ssackdama.ssackdama.domain.Store;
import ssackdama.ssackdama.service.StoreServiceImpl;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreServiceImpl storeServiceImpl;
    @GetMapping("/")
    public String test(Model model){
        List<Store> storeList = storeServiceImpl.getAllStores();

        model.addAttribute("storeList",storeList);
        return "pages/index";
    }

}
