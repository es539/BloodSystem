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

public class Donation {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "2972001333";

    //    int numSameRegionAuth = 0;
    @GetMapping("/sameRegion")
    public String sameRegionAuth(){
        String region = Registration.userData.getRegion();
        String res ="";
        final String QUERY = "select authName,phone,address, donationtimeFrom, donationtimeTo from authority where region= \"" + region + "\";";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
//                numSameRegionAuth++;
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String phone = rs.getString("phone");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+phone+","+dTimeFrom+","+dTimeTo+",";
//                numSameRegionAuth++;
            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }

//    @GetMapping("/numSameRegion")
//    public int getNumSameRegionAuth(){ return numSameRegionAuth; }

    @GetMapping("/sameCity")
    public String sameCityAuth(){
        String region = Registration.userData.getRegion();
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        final String QUERY = "select authName,phone,address,region, donationtimeFrom, donationtimeTo from authority where region != \"" + region + "\" and city = \""+city+"\";";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String phone = rs.getString("phone");
                String reg = rs.getString("region");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+reg+","+phone+","+dTimeFrom+","+dTimeTo+",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }

    @GetMapping("/otherCities")
    public String farAuth(){
        String region = Registration.userData.getRegion();
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        final String QUERY = "select authName,phone,address, region, city, donationtimeFrom, donationtimeTo from authority where region != \"" + region + "\" and city != \""+city+"\";";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                //Display values
                String name = rs.getString("authName");
                String address= rs.getString("address");
                String phone = rs.getString("phone");
                String reg = rs.getString("region");
                String c = rs.getString("city");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+reg+","+c+","+phone+","+dTimeFrom+","+dTimeTo+",";
            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
}