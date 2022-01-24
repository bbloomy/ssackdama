package ssackdama.ssackdama.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ssackdama.ssackdama.service.StoreServiceImpl;

@Controller
public class StoreController {

    @Autowired
    StoreServiceImpl storeServiceImpl;

}
