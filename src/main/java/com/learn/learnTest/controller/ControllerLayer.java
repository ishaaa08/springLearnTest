package com.learn.learnTest.controller;

//import java.util.Map;

import ch.qos.logback.core.joran.sanity.Pair;
import com.learn.learnTest.model.DataBase;
import com.learn.learnTest.repository.SaveDb;
import com.learn.learnTest.service.ServiceLayer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/test/change")
   public Map<String, List<String>> changeAddress(@RequestBody DataBase db){
        return serviceLayer.changeAddress(db);
    }

    @PostMapping("/test/changeAddress")
    public String changeAddresss(@RequestParam String operation ,@RequestParam String address) {
        return serviceLayer.changeAddress(operation,address);
    }


}
