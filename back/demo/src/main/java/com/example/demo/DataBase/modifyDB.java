package com.example.demo.DataBase;


import com.example.demo.Registration.authority;
import com.example.demo.Registration.registration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@CrossOrigin
@RequestMapping("/savior")
public class modifyDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "2972001333";

    public String editAuthProfile(authority authAcc) {
//            System.out.println(QUERY);
        String response = "valid";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);

            if (authAcc.getName() != null) {
                String QUERY = "UPDATE authority SET authName = '" + authAcc.getName() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("name updated successfully...");
            }

            if (authAcc.getEmail() != null) {
                String QUERY = "UPDATE authority SET email = '" + authAcc.getEmail() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("mail updated successfully...");
            }
            if (authAcc.getPhone() != null) {
                String QUERY = "UPDATE authority SET phone = '" + authAcc.getPhone() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                stmt.executeUpdate(QUERY);
                System.out.println("phone updated successfully...");
            }
            if (authAcc.getPassword() != null) {
                String QUERY = "UPDATE authority SET authpassword = '" + authAcc.getPassword() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                stmt.executeUpdate(QUERY);
                System.out.println(QUERY);
                System.out.println("password updated successfully...");
            }
            if (authAcc.getAddress() != null) {
                String QUERY = "UPDATE authority SET address = '" + authAcc.getAddress() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("address updated successfully...");
            }
            if (authAcc.getCity() != null) {
                String QUERY = "UPDATE authority SET city = '" + authAcc.getCity() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("city updated successfully...");
            }
            if (authAcc.getRegion() != null) {
                String QUERY = "UPDATE authority SET region = '" + authAcc.getRegion() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("region updated successfully...");
            }

            if (authAcc.getStartWork() != null) {
                String QUERY = "UPDATE authority SET workinghours_start = '" + authAcc.getStartWork() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("working hours updated successfully...");
            }
            if (authAcc.getEndWork() != null) {
                String QUERY = "UPDATE authority SET workinghours_close = '" + authAcc.getEndWork() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("working hours updated successfully...");
            }
            if (authAcc.getDonationtimeFrom() != null) {
                String QUERY = "UPDATE authority SET donationtimeFrom = '" + authAcc.getDonationtimeFrom() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("donation time from updated successfully...");
            }
            if (authAcc.getDonationtimeTo() != null) {
                String QUERY = "UPDATE authority SET donationtimeTo = '" + authAcc.getDonationtimeTo() + "' WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("donation time to updated successfully...");

            }

            if(authAcc.getE_Aplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aplus_exist = " + authAcc.getE_Aplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A+ exist updated successfully...");
            }
            if(authAcc.getN_Aplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aplus_needed = " + authAcc.getN_Aplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A+ neeeded updated successfully...");
            }

            if(authAcc.getE_Aminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aminus_exist = " + authAcc.getE_Aminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A- exist updated successfully...");
            }
            if(authAcc.getN_Aminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Aminus_needed = " + authAcc.getN_Aminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("A- neeeded updated successfully...");
            }

            if(authAcc.getE_Bplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bplus_exist = " + authAcc.getE_Bplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B+ exist updated successfully...");
            }
            if(authAcc.getN_Bplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bplus_needed = " + authAcc.getN_Bplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B+ needed updated successfully...");
            }
//
            if(authAcc.getE_Bminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bminus_needed = " + authAcc.getE_Bminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B- exist updated successfully...");
            }
            if(authAcc.getN_Bminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Bminus_needed = " + authAcc.getN_Bminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("B- needed updated successfully...");
            }

            if(authAcc.getE_ABplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABplus_exist = " + authAcc.getE_ABplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB+ exist updated successfully...");
            }
            if(authAcc.getN_ABplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABplus_needed = " + authAcc.getN_ABplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB+ needed updated successfully...");
            }


            if(authAcc.getE_ABminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABminus_exist = " + authAcc.getE_ABminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB- exist updated successfully...");
            }
            if(authAcc.getN_ABminus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET ABminus_needed = " + authAcc.getN_ABminus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("AB- needed updated successfully...");
            }


            if(authAcc.getE_Oplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Oplus_exist = " + authAcc.getE_Oplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O+ exist updated successfully...");
            }
            if(authAcc.getN_Oplus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Oplus_needed = " + authAcc.getN_Oplus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O+ needed updated successfully...");
            }
            if(authAcc.getE_Ominus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Ominus_exist = " + authAcc.getE_Ominus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O- exist updated successfully...");
            }
            if(authAcc.getN_Ominus() >= 0)
            {
                String QUERY = "UPDATE bagsNumber SET Ominus_needed = " + authAcc.getN_Ominus() + " WHERE tax = '" + registration.authData.getTax() + "';";
                System.out.println(QUERY);
                stmt.executeUpdate(QUERY);
                System.out.println("O- needed updated successfully...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;



    }



}
