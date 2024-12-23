package com.learn.learnTest.repository;

import com.learn.learnTest.model.DataBase;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveDb {


    Map<String, DataBase> databaseMap=new HashMap<>();
    private int flag=0;
    private DataBase oldDb;


    public String saveDetails(DataBase db){
        databaseMap.put(db.getEmail(),db);
        return "details saved";

    }

    public Map<String, List<String>> changeAddress(DataBase db){
        String email=db.getEmail();
        String password=db.getPassword();
        Map<String, List<String>> temp=new HashMap<>();
        try{
            oldDb=databaseMap.get(email);
            if (oldDb.getPassword().equals(password)) {
                flag=1;
                temp.put("choose address that needs to be replaced by entering its number or just write 'add' in operation if want to add address", oldDb.getAddressList());
                return temp;
            }else{
                temp.put("wrong password",Collections.emptyList());
                return  temp;
            }
        }catch (Exception e){
            temp.put(e.getMessage(), Collections.emptyList());
            return  temp;

        }

    }

    public String changeAddress(String operation,String address){
        if(flag==1){
            if(operation.toLowerCase().equals("add")){
                oldDb.setAddress(address);
                return "successfully added address";
            }
            else{
                oldDb.replaceAddress(Integer.valueOf(operation),address);
                return "successfully replaced address";
            }
        }
        return "enter your details then add/replace address";
    }

    public String fetchDetails(String email, String password){
        try {
            DataBase db=databaseMap.get(email);
            if(db.getPassword().equals(password)){
                return db.toString();
            }else{
                return "wrong password";
            }
        }catch (Exception e){
            return e.getMessage();
        }

    }

}
