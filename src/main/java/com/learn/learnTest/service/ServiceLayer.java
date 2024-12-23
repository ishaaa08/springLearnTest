package com.learn.learnTest.service;

import ch.qos.logback.core.joran.sanity.Pair;
import com.learn.learnTest.model.DataBase;
import com.learn.learnTest.repository.SaveDb;

import java.util.List;
import java.util.Map;

public class ServiceLayer {
    private SaveDb saveDb = new SaveDb();

    public String saveDetails(DataBase db){
        String email=db.getEmail();
        String password=db.getPassword();
        long phone=db.getPhone();
        if(email.contains("@") && email.contains(".com")){
            if(String.valueOf(phone).length()==10){
                if(isvalidPassword(password)){
                    return saveDb.saveDetails(db);
                }
                return "invalid password; it should be atleast 8 digit & add atleast 1 special character, 1 uppercase[A-Z],1 lowercase[a-z], 1 number";
            }else{
                return "invalid number";
            }
        }
        return "invalid email";

    }

    public Map<String, List<String>> changeAddress(DataBase db){
        return saveDb.changeAddress(db);
    }

    public String changeAddress(String operation,String address){
        return saveDb.changeAddress(operation,address);

    }

    public String fetchDetails(String email,String password){
        return saveDb.fetchDetails(email,password);
    }

    public boolean isvalidPassword(String password){
        if(password.length()<8){
            return false;
        }else{
            if(passwordSpecial(password) && passwordUppercase(password) && passwordLowecase(password) && passwordNum(password)){
                return true;
            }
            return false;
        }
    }



    public boolean passwordUppercase(String password){
        for(char i :password.toCharArray()){
            if(Character.isUpperCase(i)){
                return true;
            }
        }
        return false;
    }

    public boolean passwordSpecial(String password){
        for(char i :password.toCharArray()){
            if ((i >= 32 && i <= 47) || (i >= 58 && i <= 64) || (i >= 91 && i <= 95) || (i >= 123 && i <= 126)) {
                return true;
            }
        }
        return false;
    }

    public boolean passwordNum(String password){
        for(char i :password.toCharArray()){
            if(Character.isDigit(i)){
                return true;
            }
        }
        return false;
    }

    public boolean passwordLowecase(String password){
        for(char i :password.toCharArray()){
            if(Character.isLowerCase(i)){
                return true;
            }
        }
        return false;
    }


}
