package com.example.demo.Registration;
import com.example.demo.DataBase.DB;

public class RegistrationController {
//    public Boolean checkID(int id){
//
//    return true;
//    }
//    public Boolean checkEmail(){
//        return true;
//    }
//    public Boolean checkPassword(){
//        return true;
//    }
//    public void createUserAcc(){
//
//    }
//    public void createAuthrityAcc(){
//    }

    public boolean validateUserInfo( long id,  String password){
        DB start = new DB();
        Boolean V = start.validateUser(id,password);
        if(V)
            return true;
        return false;
    }

    public boolean validateAuthorityInfo( String tax,  String password){
        DB start = new DB();
        Boolean V = start.validateAuthority(tax, password);
        if(V) {
            return true;
        }
        return false;
    }

    public Boolean signIn(){
        return true;
    }

}
