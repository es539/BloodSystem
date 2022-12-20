package com.example.demo.Registration;


import com.example.demo.DataBase.DB;

public class registrationController {
    public boolean validateAuthorityInfo( String email,  String password){
        DB start = new DB();
        Boolean V = start.validateAuthority(email, password);
        if(V) {
            return true;
        }
        return false;
    }

    public boolean validateUserInfo( long id,  String password){
        DB start = new DB();
        Boolean V = start.validateUser(id,password);
        if(V)
            return true;
        return false;
    }
}
