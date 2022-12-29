package com.example.demo.BloodTransfution;

import com.example.demo.DataBase.DB;

import java.sql.*;

public class Acception {


    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "root";
    public String sameRegionAuth(String region,String BT){
        String res ="";
         String query = "select authName,phone,address from authority";
        if(BT.equals("A+")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = '" + region+"' &(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = '" + region+"'&(bagsNumber.Aminus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = '" + region+"' &(bagsNumber.Bplus_exist !=0 | " +
                    "bagsNumber.Bminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B-")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = '" + region+"' &(bagsNumber.Bminus_exist != 0  | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = '" + region+"' &(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Bplus_exist != 0 | bagsNumber.Bminus_exist != 0 |" +
                    "bagsNumber.ABplus_exist != 0 | bagsNumber.ABminus_exist != 0" +
                    "| bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region = '" + region+ "' &(bagsNumber.Aminus_exist !=0 | " +
                    "bagsNumber.ABminus_exist != 0 | bagsNumber.Bminus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O+")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = '" + region+ "' &(bagsNumber.Oplus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O-")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region = '" + region+ "'&(bagsNumber.Ominus_exist != 0) ; ";
        }

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

    public String sameCityAuth(String region,String BT){
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        String query = "select authName,phone,address from authority";
        if(BT.equals("A+")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"' " +
                    "& city = '"+city+"'&(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city = '"+city+"'&(bagsNumber.Aminus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city = '"+city+"' &(bagsNumber.Bplus_exist !=0 | " +
                    "bagsNumber.Bminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B-")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+"'& city = '"+city+"' &(bagsNumber.Bminus_exist != 0  | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city = '"+city+"' &(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Bplus_exist != 0 | bagsNumber.Bminus_exist != 0 |" +
                    "bagsNumber.ABplus_exist != 0 | bagsNumber.ABminus_exist != 0" +
                    "| bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+ "'& city = '"+city+"' &(bagsNumber.Aminus_exist !=0 | " +
                    "bagsNumber.ABminus_exist != 0 | bagsNumber.Bminus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O+")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+ "' & city = '"+city+"'&(bagsNumber.Oplus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O-")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+ "'& city = '"+city+"'&(bagsNumber.Ominus_exist != 0) ; ";
        }

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
                String phone = rs.getString("phone");
                res=res+name+","+address+","+region+","+phone+",";
            }
            if(res.length()!=0){
                res=res.substring(0,res.length()-1);}
            System.out.println(res);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return res;
    }
    public String farAuth(String region,String BT){
        String res ="";
        DB db = new DB();
        String city = db.getCity(region);
        String query = "select authName,phone,address from authority";
        if(BT.equals("A+")){
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"' " +
                    "& city != '"+city+"'&(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("A-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city != '"+city+"'&(bagsNumber.Aminus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("B+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city != '"+city+"' &(bagsNumber.Bplus_exist !=0 | " +
                    "bagsNumber.Bminus_exist != 0 | bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        }else if (BT.equals("B-")){
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+"'& city != '"+city+"' &(bagsNumber.Bminus_exist != 0  | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB+")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+"'& city != '"+city+"' &(bagsNumber.Aplus_exist !=0 | " +
                    "bagsNumber.Aminus_exist != 0 | bagsNumber.Bplus_exist != 0 | bagsNumber.Bminus_exist != 0 |" +
                    "bagsNumber.ABplus_exist != 0 | bagsNumber.ABminus_exist != 0" +
                    "| bagsNumber.Oplus_exist != 0 | bagsNumber.Ominus_exist != 0); ";
        } else if (BT.equals("AB-")) {
            query += " INNER JOIN bagsNumber  ON authority.tax = bagsNumber.tax where region != '" + region+ "'& city != '"+city+"' &(bagsNumber.Aminus_exist !=0 | " +
                    "bagsNumber.ABminus_exist != 0 | bagsNumber.Bminus_exist != 0 | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O+")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+ "' & city != '"+city+"'&(bagsNumber.Oplus_exist != 0  | bagsNumber.Ominus_exist != 0) ; ";
        } else if (BT.equals("O-")) {
            query += " INNER JOIN bagsNumber ON authority.tax = bagsNumber.tax where region != '" + region+ "'& city != '"+city+"'&(bagsNumber.Ominus_exist != 0) ; ";
        }

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
                String phone = rs.getString("phone");
                res=res+name+","+address+","+region+","+city+","+phone+",";
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
