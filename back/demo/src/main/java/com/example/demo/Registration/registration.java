package com.example.demo.Registration;

import com.example.demo.DataBase.DB;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/savior")

public class registration {
    public static authority authData = new authority();
    @GetMapping("/signUpA")

    public String signUp(@RequestParam String email, @RequestParam String phone, @RequestParam String pass, @RequestParam String name, @RequestParam String adrs,
                         @RequestParam String region, @RequestParam String tax, @RequestParam String start, @RequestParam String end,
                         @RequestParam String donationF, @RequestParam String donationT,
                         @RequestParam int EAplus, @RequestParam int NAplus, @RequestParam int EAminus, @RequestParam int NAminus,
                         @RequestParam int EBplus, @RequestParam int NBplus, @RequestParam int EBminus, @RequestParam int NBminus,
                         @RequestParam int EABplus, @RequestParam int NABplus, @RequestParam int EABminus, @RequestParam int NABminus,
                         @RequestParam int EOplus, @RequestParam int NOplus, @RequestParam int EOminus, @RequestParam int NOminus){
        DB adding = new DB();
        authData.setEmail(email); authData.setPhone(phone); authData.setPassword(pass); authData.setName(name);
        authData.setAddress(adrs); authData.setRegion(region); authData.setTax(tax);
        authData.setStartWork(start); authData.setEndWork(end);authData.setDonationtimeFrom(donationF);authData.setDonationtimeTo(donationT);
        authData.setE_Aplus(EAplus); authData.setN_Aplus(NAplus); authData.setE_Aminus(EAminus); authData.setN_Aminus(NAminus);
        authData.setE_Bplus(EBplus); authData.setN_Bplus(NBplus); authData.setE_Bminus(EBminus); authData.setN_Bminus(NBminus);
        authData.setE_ABplus(EABplus); authData.setN_ABplus(NABplus); authData.setE_ABminus(EABminus); authData.setN_ABminus(NABminus);
        authData.setE_Oplus(EOplus); authData.setN_Oplus(NOplus); authData.setE_Ominus(EOminus); authData.setN_Ominus(NOminus);
        String response;
        if(adding.checkForNoduplicateAuthorities(tax)==false){
            response = adding.addAuthority(authData);
        }else{
            response = "invalid";
        }
        return response;
    }


}