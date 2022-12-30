package com.example.demo.BloodTransfution;

import com.example.demo.Registration.Registration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
@CrossOrigin
@RequestMapping("/savior")
public class WaitingList {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "2972001333";

    public String getWaitingListAccept(){
        String res ="";
        final String QUERY = "select * from waitingListAccept;";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                String name = rs.getString("acceptorName");
                String id = rs.getString("userId");
                String bt = rs.getString("bloodtype");
                res += res + name + "," + id + "," + bt + ",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;

    }
    public String setWaitingListAccept(String name,long id, String BT){
        final String QUERY = "insert into waitingListAccept values('"+name+"'," + id+",'"+BT+"');";
        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(QUERY);
            System.out.println("inserted successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "valid";
    }

    @GetMapping("/setWaiting")
    public String setWaitingListDonate(){
        String name = Registration.userData.getName();
        long id = Registration.userData.getId();
        String BT = Registration.userData.getBloodtype();

        final String QUERY = "insert into waitingListDonate values('"+name+"'," + id+",'"+BT+"');";
        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(QUERY);
            System.out.println("inserted successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Done";
    }


    public String getWaitingListDonate(){
        String res ="";
        final String QUERY = "select * from waitingListDonate;";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                String name = rs.getString("donatorName");
                String id = rs.getString("userId");
                String bt = rs.getString("bloodtype");
                res += res + name + "," + id + "," + bt + ",";

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
