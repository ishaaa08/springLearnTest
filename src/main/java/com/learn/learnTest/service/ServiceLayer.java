package com.learn.learnTest.service;

import com.learn.learnTest.model.DataBase;
import com.learn.learnTest.repository.SaveDb;

public class ServiceLayer {
    private SaveDb saveDb = new SaveDb();

    public String saveDetails(DataBase db){
        return saveDb.saveDetails(db);

    }

    public String changeAddress(String email,String password,String address){
        return saveDb.changeAddress(email,password,address);
    }

    public String fetchDetails(String email,String password){
        return saveDb.fetchDetails(email,password);
    }
}
