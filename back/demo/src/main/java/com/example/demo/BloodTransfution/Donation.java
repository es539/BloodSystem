package com.example.demo.BloodTransfution;
import com.example.demo.DataBase.DB;

import java.sql.*;
import java.util.List;

public class Donation {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "Sola.123#";
    public String sameRegionAuth(String region){
        String res ="";
        final String QUERY = "select authName,phone,address from authority where region= \"" + region + "\";";
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
                res=res+name+","+address+","+phone+",";
            }
            if(res.length()!=0){
            res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }

    public String sameCityAuth(String region){
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        final String QUERY = "select authName,phone,address from authority where region != \"" + region + "\" and city = \""+city+"\";";

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
                res=res+name+","+address+","+phone+",";
            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
    public String farAuth(String region){
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        final String QUERY = "select authName,phone,address from authority where region != \"" + region + "\" and city != \""+city+"\";";

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
                res=res+name+","+address+","+phone+",";
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
