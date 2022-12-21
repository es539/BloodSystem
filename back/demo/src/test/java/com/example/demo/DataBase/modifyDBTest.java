package com.example.demo.DataBase;

import com.example.demo.Registration.Authority;
import com.example.demo.Registration.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyDBTest {
    //test editUserProfile
    @Test
    void givenRightUserThenValid(){
        ModifyDB test = new ModifyDB();
        User myuser = new User();
        myuser.setPassword("5057555048484951");myuser.setName("Esraa");myuser.setAge(21);
        myuser.setWeight(65);myuser.setBloodtype("A+");myuser.setAddress("Mohamed Helmy st.");
        myuser.setCity("Alexandria");myuser.setRegion("Montaza");
        assertEquals(test.editUserProfile(myuser),"valid");
    }

    //test editauthProfile
    @Test
    void givenRightAuthThenValid(){
        ModifyDB test = new ModifyDB();
        Authority myauth = new Authority();
        myauth.setEmail("Shefaae@gmail.com");myauth.setPassword("1151041011029711510410110297");myauth.setName("esraa");
        myauth.setAddress("Malaka Hefny st.");myauth.setPhone("04444444444");
        myauth.setCity("null");myauth.setRegion("Bulaq");
        myauth.setStartWork("12:00:00");myauth.setEndWork("00:00:00");
        myauth.setDonationtimeFrom("17:00:00");myauth.setDonationtimeTo("20:30:00");
        myauth.setN_Aplus(4);myauth.setE_Aplus(4);myauth.setN_Aminus(4);myauth.setE_Aminus(4);
        myauth.setN_Bplus(4);myauth.setE_Bplus(4);myauth.setN_Bminus(4);myauth.setE_Bminus(5);
        myauth.setN_ABplus(4);myauth.setE_ABplus(4);myauth.setN_ABminus(4);myauth.setE_ABminus(4);
        myauth.setN_Oplus(4);myauth.setE_Oplus(4);myauth.setN_Ominus(4);myauth.setE_Ominus(4);
        assertEquals(test.editAuthProfile(myauth),"valid");
    }

}