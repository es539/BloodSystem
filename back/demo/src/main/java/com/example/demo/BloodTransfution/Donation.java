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

   public String donationTicket (String nameAuth, String addrs){
        String res ="";
        final String QUERY = "select * from authority where authName = \"" + nameAuth + "\" and address = \""+addrs+"\";";

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
                String c = rs.getString("city");
                String reg = rs.getString("region");
                String wTimeStart = rs.getString("workinghours_start");
                String wTimeClose = rs.getString("workinghours_close");
                String dTimeFrom = rs.getString("donationtimeFrom");
                String dTimeTo =rs.getString("donationtimeTo");
                res=res+name+","+phone+","+address+","+c+","+reg+","+wTimeStart+","+wTimeClose+","+dTimeFrom+","+dTimeTo+",";
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
    @GetMapping("/chooseAuth")
    String chosenAuth(@RequestParam String name, @RequestParam String address){
        chosenAuth.setName(name);
        chosenAuth.setAddress(address);
        System.out.println("name" + chosenAuth.getName());
        System.out.println("address" + chosenAuth.getAddress());
        return "Done";}
}