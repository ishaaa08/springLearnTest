package com.learn.learnTest.controller;

//import java.util.Map;

import com.learn.learnTest.model.DataBase;
import com.learn.learnTest.repository.SaveDb;
import com.learn.learnTest.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerLayer {

    private ServiceLayer serviceLayer=new ServiceLayer();
//    @GetMapping("test/helo")
//    public String helo() {
//        return "helo";
//    }

    @PostMapping("/test/login")
    public String login(@RequestParam String email, @RequestParam String password){
        return serviceLayer.fetchDetails(email,password);
    }

    @PostMapping("/test/signup")
    public String saveDetails(@RequestBody DataBase db){
        return serviceLayer.saveDetails(db);
    }

    @PostMapping("/test/changeAddress")
   public String changeAddress(@RequestParam String email, @RequestParam String password , @RequestParam String address){
        return serviceLayer.changeAddress(email,password,address);
    }


}
