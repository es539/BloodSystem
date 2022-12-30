package com.example.demo.BloodTransfution;
import com.example.demo.DataBase.DB;
import com.example.demo.Registration.Authority;
import com.example.demo.Registration.Registration;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
@CrossOrigin
@RequestMapping("/savior")

public class Donation {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "aboshady2001@Esraa";

    //    int numSameRegionAuth = 0;
    @GetMapping("/sameRegion")
    public String sameRegionAuth(){
        String region = Registration.userData.getRegion();
        String res ="";
        final String QUERY = "select authName,phone,address,region, city, donationtimeFrom, donationtimeTo from authority where region= \"" + region + "\";";
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
                String reg = rs.getString("region");
                String c = rs.getString("city");
                String phone = rs.getString("phone");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+address+","+reg+","+c+","+phone+","+dTimeFrom+","+dTimeTo+",";
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
        final String QUERY = "select authName,phone,address,region, city, donationtimeFrom, donationtimeTo from authority where region != \"" + region + "\" and city = \""+city+"\";";

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
                String reg = rs.getString("region");
                String c = rs.getString("city");
                String phone = rs.getString("phone");
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
    Authority chosenAuth = new Authority();
   public String donationTicket (){
        String res ="";
        final String QUERY = "select * from authority where authName = \"" + chosenAuth.getName() + "\" and address = \""+chosenAuth.getAddress()+"\";";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                //Display values
                chosenAuth.setPhone(rs.getString("phone"));
                chosenAuth.setCity(rs.getString("city"));
                chosenAuth.setRegion( rs.getString("region"));
                chosenAuth.setStartWork(rs.getString("workinghours_start"));
                chosenAuth.setEndWork( rs.getString("workinghours_close"));
                chosenAuth.setDonationtimeFrom( rs.getString("donationtimeFrom"));
                chosenAuth.setDonationtimeTo(rs.getString("donationtimeTo"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return "done";
    }

    @GetMapping("/chooseAuth")
    String chosenAuth(@RequestParam String name, @RequestParam String address){
        chosenAuth.setName(name);
        chosenAuth.setAddress(address);
        System.out.println("name" + chosenAuth.getName());
        System.out.println("address" + chosenAuth.getAddress());
        return "Done";}
    @GetMapping("/chosenAuthName")
    String getChosenAuthName(){ return chosenAuth.getName(); }
    @GetMapping("/chosenAuthAddress")
    String getChosenAuthAddressName(){ return chosenAuth.getAddress(); }

    @GetMapping("/chosenAuthPhone")
    String getChosenAuthPhone(){ return chosenAuth.getPhone(); }
    @GetMapping("/chosenAuthRegion")
    String getChosenAuthAddressRegion(){ return chosenAuth.getRegion(); }
    @GetMapping("/chosenAuthCity")
    String getChosenAuthCity(){ return chosenAuth.getCity(); }
    @GetMapping("/chosenAuthWStart")
    String getChosenAuthAddressWStart(){ return chosenAuth.getStartWork(); }
    @GetMapping("/chosenAuthWClose")
    String getChosenAuthWclose(){ return chosenAuth.getEndWork(); }
    @GetMapping("/chosenAuthDFrom")
    String getChosenAuthAddressDFrom(){ return chosenAuth.getDonationtimeFrom(); }
    @GetMapping("/chosenAuthDTo")
    String getChosenAuthAddressDTo(){ return chosenAuth.getDonationtimeTo(); }

    @GetMapping("/UserName")
    String getUserName(){ return Registration.userData.getName(); }

}