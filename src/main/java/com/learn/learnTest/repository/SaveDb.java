package com.learn.learnTest.repository;

import com.learn.learnTest.model.DataBase;

import java.util.HashMap;
import java.util.Map;

public class SaveDb {


    Map<String, DataBase> databaseMap=new HashMap<>();

    public String saveDetails(DataBase db){
        databaseMap.put(db.getEmail(),db);
        return "details saved";

    }

    public String changeAddress(String email,String password,String address){
        DataBase db=databaseMap.get(email);
        if(db!=null && db.getPassword().equals(password)){
            db.setAddress(address);
            return "successfully changed address";
        }
        return "error logging in";

    }

    public String fetchDetails(String email, String password){
        DataBase db=databaseMap.get(email);
        if(db.getPassword().equals(password)){
            return db.toString();
        }
        return "error logging in";

    }

}
