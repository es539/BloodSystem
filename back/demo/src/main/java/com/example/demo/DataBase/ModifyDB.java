package com.example.demo.DataBase;

import com.example.demo.Registration.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
@CrossOrigin
@RequestMapping("/savior")

public class ModifyDB {
    static final String DB_URL = "jdbc:postgresql://db.vxmcbqcizclgrmucashg.supabase.co:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "Salma/saeed/1911/z";



    @GetMapping("/modifyPassI")
    public String modifyUserPass(@RequestParam long id , @RequestParam String pass){
        DB start = new DB();
        String response;
        if(start.checkForNoduplicateUsers(id)==false){   //this id has no account
            response = "invalid";
        }else {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                String QUERY = "update userprofile set userpassword =\"" + pass + "\" " + "where id =" + id;
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
//                registration.userData.setPassword(pass);
                DB profile = new DB();
                Registration.userData = profile.getUserData(id, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response = "valid";
        }
        return response;
    }

    @GetMapping("/modifyPassA")
    public String modifyAuthorityPass(@RequestParam String tax , @RequestParam String pass){
        DB start = new DB();
        String response;
        if(start.checkForNoduplicateAuthorities(tax)==false){   //this tax has no account
            response = "invalid";
        }else {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                String QUERY = "update authority set authpassword =\"" + pass + "\" " + "where tax =\"" + tax + "\"" + ";";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                //registration.authData.setPassword(pass);
                DB profile = new DB();
                Registration.authData = profile.getAuthData(tax, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response = "valid";
        }
        return response;
    }


    public String editUserProfile(User userAcc) {
        String response = "valid";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            if (userAcc.getName() != null) {
                final String QUERY = "UPDATE userProfile SET userName = '" + userAcc.getName() + "' WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("name updated successfully...");
            }
            if (userAcc.getPassword() != null) {
                String QUERY = "UPDATE userProfile SET userpassword = '" + userAcc.getPassword() + "' WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("password updated successfully...");
            }
            if (userAcc.getAddress() != null) {
                final String QUERY = "UPDATE userProfile SET address = '" + userAcc.getAddress() + "' WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("address updated successfully...");
            }

            if (userAcc.getCity() != null) {
                String QUERY = "UPDATE userProfile SET city = '" + userAcc.getCity() + "' WHERE id = '" + Registration.userData.getId() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("city updated successfully...");
            }
            if (userAcc.getRegion() != null) {
                String QUERY = "UPDATE userProfile SET region = '" + userAcc.getRegion() + "' WHERE id = '" + Registration.userData.getId() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("region updated successfully...");
            }
            if (userAcc.getAge() != 0) {
                final String QUERY = "UPDATE userProfile SET age = " + userAcc.getAge() + " WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("age updated successfully...");
            }
            if (userAcc.getWeight() != 0) {
                final String QUERY = "UPDATE userProfile SET weight = " + userAcc.getWeight() + " WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("weight updated successfully...");
            }
            if (userAcc.getBloodtype() != null) {
                final String QUERY = "UPDATE userProfile SET bloodtype = '" + userAcc.getBloodtype() + "' WHERE id = " + Registration.userData.getId() + ";";
                stmt.executeUpdate(QUERY);
                System.out.println("blood type updated successfully...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public String editAuthProfile(Authority authAcc) {
//            System.out.println(QUERY);
        String response = "valid";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);

            if (authAcc.getName() != null) {
                String QUERY = "UPDATE authority SET authName = '" + authAcc.getName() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("name updated successfully...");
            }

            if (authAcc.getEmail() != null) {
                String QUERY = "UPDATE authority SET email = '" + authAcc.getEmail() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("mail updated successfully...");
            }
            if (authAcc.getPhone() != null) {
                String QUERY = "UPDATE authority SET phone = '" + authAcc.getPhone() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                stmt.executeUpdate(QUERY);
                System.out.println("phone updated successfully...");
            }
            if (authAcc.getPassword() != null) {
                String QUERY = "UPDATE authority SET authpassword = '" + authAcc.getPassword() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                stmt.executeUpdate(QUERY);
                System.out.println(QUERY);
                System.out.println("password updated successfully...");
            }
            if (authAcc.getAddress() != null) {
                String QUERY = "UPDATE authority SET address = '" + authAcc.getAddress() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("address updated successfully...");
            }
            if (authAcc.getCity() != null) {
                String QUERY = "UPDATE authority SET city = '" + authAcc.getCity() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("city updated successfully...");
            }
            if (authAcc.getRegion() != null) {
                String QUERY = "UPDATE authority SET region = '" + authAcc.getRegion() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("region updated successfully...");
            }

            if (authAcc.getStartWork() != null) {
                String QUERY = "UPDATE authority SET workinghours_start = '" + authAcc.getStartWork() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("working hours updated successfully...");
            }
            if (authAcc.getEndWork() != null) {
                String QUERY = "UPDATE authority SET workinghours_close = '" + authAcc.getEndWork() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("working hours updated successfully...");
            }
            if (authAcc.getDonationtimeFrom() != null) {
                String QUERY = "UPDATE authority SET donationtimeFrom = '" + authAcc.getDonationtimeFrom() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("donation time from updated successfully...");
            }
            if (authAcc.getDonationtimeTo() != null) {
                String QUERY = "UPDATE authority SET donationtimeTo = '" + authAcc.getDonationtimeTo() + "' WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("donation time to updated successfully...");

            }

            if(authAcc.getE_Aplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aplus_exist = " + authAcc.getE_Aplus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A+ exist updated successfully...");
            }

            if(authAcc.getE_Aminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aminus_exist = " + authAcc.getE_Aminus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A- exist updated successfully...");
            }

            if(authAcc.getE_Bplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bplus_exist = " + authAcc.getE_Bplus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B+ exist updated successfully...");
            }

            if(authAcc.getE_Bminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bminus_needed = " + authAcc.getE_Bminus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B- exist updated successfully...");
            }

            if(authAcc.getE_ABplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABplus_exist = " + authAcc.getE_ABplus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB+ exist updated successfully...");
            }

            if(authAcc.getE_ABminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABminus_exist = " + authAcc.getE_ABminus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB- exist updated successfully...");
            }

            if(authAcc.getE_Oplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Oplus_exist = " + authAcc.getE_Oplus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O+ exist updated successfully...");
            }

            if(authAcc.getE_Ominus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Ominus_exist = " + authAcc.getE_Ominus() + " WHERE tax = '" + Registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O- exist updated successfully...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;



    }



}
