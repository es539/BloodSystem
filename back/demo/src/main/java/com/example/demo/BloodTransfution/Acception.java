package com.example.demo.BloodTransfution;

import com.example.demo.DataBase.DB;
import com.example.demo.Registration.Registration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
@RestController
@CrossOrigin
@RequestMapping("/savior")

public class Acception {


    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "aboshady2001@Esraa";
    @GetMapping("/sameRegionCity")
    public String sameRegionAuth(){
        String region = Registration.userData.getRegion();
        String BT = Registration.userData.getBloodtype();
        String res ="";
        System.out.println(region);
        System.out.println(BT);
        String query = "select authName,address,region,city,phone,donationtimeFrom,donationtimeTo from authority";



        if(BT.equals("A positive")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = \"" + region+"\" and(bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = \"" + region+"\" and(bagsNumber.Aminus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = \"" + region+"\" and(bagsNumber.Bplus_exist !=0 or " +
                    "bagsNumber.Bminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B negative")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = \"" + region+"\" and(bagsNumber.Bminus_exist != 0  or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = \"" + region+"\" and(bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Bplus_exist != 0 or bagsNumber.Bminus_exist != 0 or" +
                    "bagsNumber.ABplus_exist != 0 or bagsNumber.ABminus_exist != 0" +
                    "or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = \"" + region+ "\" and(bagsNumber.Aminus_exist !=0 or " +
                    "bagsNumber.ABminus_exist != 0 or bagsNumber.Bminus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O positive")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = \"" + region+ "\" and(bagsNumber.Oplus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O negative")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = \"" + region+ "\" and(bagsNumber.Ominus_exist != 0) ; ";
        }

        System.out.println(query);
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String authRegion = rs.getString("region");
                String authCity = rs.getString("city");
                String phone = rs.getString("phone");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+authRegion+","+authCity+","+phone+","+dTimeFrom+","+dTimeTo+",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }

    @GetMapping("/sameCityDiffRegion")
    public String sameCityAuth(){
        String region = Registration.userData.getRegion();
        String BT = Registration.userData.getBloodtype();
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        String query = "select authName,address,region,city,phone,donationtimeFrom,donationtimeTo from authority";

        if(BT.equals("A positive")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" " +
                    "and city = \""+city+"\" and (bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city = \""+city+"\" and(bagsNumber.Aminus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city = \""+city+"\" and(bagsNumber.Bplus_exist !=0 or " +
                    "bagsNumber.Bminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B negative")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city = \""+city+"\" and(bagsNumber.Bminus_exist != 0  or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city = \""+city+"\" and(bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Bplus_exist != 0 or bagsNumber.Bminus_exist != 0 or" +
                    "bagsNumber.ABplus_exist != 0 or bagsNumber.ABminus_exist != 0" +
                    "| bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+ "\" and city = \""+city+"\" and(bagsNumber.Aminus_exist !=0 or " +
                    "bagsNumber.ABminus_exist != 0 or bagsNumber.Bminus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O positive")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+ "\" and city = \""+city+"\" and(bagsNumber.Oplus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O negative")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+ "\" and city = \""+city+"\" and(bagsNumber.Ominus_exist != 0) ; ";
        }
        System.out.println(query);

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String authRegion = rs.getString("region");
                String authCity = rs.getString("city");
                String phone = rs.getString("phone");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+authRegion+","+authCity+","+phone+","+dTimeFrom+","+dTimeTo+",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
    @GetMapping("/DiffCityRegion")
    public String farAuth(){
        String region = Registration.userData.getRegion();
        String BT = Registration.userData.getBloodtype();
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        String query = "select authName,address,region,city,phone,donationtimeFrom,donationtimeTo from authority";

        if(BT.equals("A positive")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" " +
                    "and city != \""+city+"\" and(bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city != \""+city+"\" and(bagsNumber.Aminus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city != \""+city+"\" and(bagsNumber.Bplus_exist !=0 or " +
                    "bagsNumber.Bminus_exist != 0 or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B negative")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city != \""+city+"\" and(bagsNumber.Bminus_exist != 0 or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB positive")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+"\" and city != \""+city+"\" and(bagsNumber.Aplus_exist !=0 or " +
                    "bagsNumber.Aminus_exist != 0 or bagsNumber.Bplus_exist != 0 | bagsNumber.Bminus_exist != 0 or" +
                    "bagsNumber.ABplus_exist != 0 or bagsNumber.ABminus_exist != 0" +
                    "or bagsNumber.Oplus_exist != 0 or bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB negative")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != \"" + region+ "\"and city != \""+city+"\" and(bagsNumber.Aminus_exist !=0 or " +
                    "bagsNumber.ABminus_exist != 0 or bagsNumber.Bminus_exist != 0 or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O positive")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+ "\" and city != '"+city+"\" and (bagsNumber.Oplus_exist != 0  or bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O negative")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != \"" + region+ "\" and city != \""+city+"\" and(bagsNumber.Ominus_exist != 0) ; ";
        }

        System.out.println(query);

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String authRegion = rs.getString("region");
                String authCity = rs.getString("city");
                String phone = rs.getString("phone");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+authRegion+","+authCity+","+phone+","+dTimeFrom+","+dTimeTo+",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
    public String AcceptFrom(String BT){
        String res ="";
        final String QUERY = "select acceptFrom from acception where btype= \"" + BT + "\";";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                res= res + rs.getString("acceptFrom");
                if(rs.next()){
                    res += ",";
                }
            }
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
}