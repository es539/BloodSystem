package com.example.demo.BloodTransfution;

import java.sql.*;

public class DoneList {
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "aboshady2001@Esraa";

    public String getDoneListAccept(){
        String res ="";
        final String QUERY = "select * from doneListAccept;";
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
                String date = rs.getString("dateAccept");
                res += res + name + "," + id + "," + bt + "," + date + ",";

            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;

    }

    public String getdoneListDonate(){
        String res ="";
        final String QUERY = "select * from doneListDonate;";
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
                String date = rs.getString("dateAccept");
                res += res + name + "," + id + "," + bt + "," + date + ",";

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
