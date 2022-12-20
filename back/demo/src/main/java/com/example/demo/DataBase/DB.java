package com.example.demo.DataBase;

import com.example.demo.Registration.authority;

import java.sql.*;

public class DB{
    static final String DB_URL = "jdbc:mysql://localhost:3306";
    static final String USER = "root";
    static final String PASS = "2972001333";
    public boolean validateTAX(String tax) {
        final String QUERY = "SELECT EXISTS(SELECT * from authoritytax WHERE tax=" + tax + ");";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);

            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from authoritytax WHERE tax=" + tax + ")");
            }
            if (valid == 1) {
                System.out.println("valid tax");
                return true;
            } else if (valid == 0) {
                System.out.println("invalid tax");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    public String addAuthority(authority newAuth){
        boolean valid = validateTAX(newAuth.getTax());
        if (valid){
            final String QUERY = "insert into authority values(\""+newAuth.getTax()
                    +"\",\""+newAuth.getPassword() +"\",\""+newAuth.getName()+"\",\""+newAuth.getEmail()
                    +"\",\""+newAuth.getPhone()+"\",\""+newAuth.getAddress()
                    +"\",\""+newAuth.getCity()+"\",\""+newAuth.getRegion()
                    +"\",\""+newAuth.getStartWork() +"\",\""+newAuth.getEndWork()
                    +"\",\""+newAuth.getDonationtimeFrom() +"\",\""+newAuth.getDonationtimeTo()+"\");\n";
            System.out.println(QUERY);
            final String QUERY2 = "insert into bagsNumber values(\""+newAuth.getTax()
                    +"\",\""+newAuth.getN_Aplus()
                    +"\",\""+newAuth.getE_Aplus()+"\",\""+newAuth.getN_Aminus()
                    +"\",\""+newAuth.getE_Aminus()+"\",\""+newAuth.getN_Bplus()
                    +"\",\""+newAuth.getE_Bplus()+"\",\""+newAuth.getN_Bminus()
                    +"\",\""+newAuth.getE_Bminus()+"\",\""+newAuth.getN_ABplus()
                    +"\",\""+newAuth.getE_ABplus()+"\",\""+newAuth.getN_ABminus()
                    +"\",\""+newAuth.getE_ABminus()+"\",\""+newAuth.getN_Oplus()
                    +"\",\""+newAuth.getE_Oplus()+"\",\""+newAuth.getN_Ominus()
                    +"\",\""+newAuth.getE_Ominus()+"\");\n";
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                stmt.executeUpdate(QUERY);
                stmt.executeUpdate(QUERY2);
                System.out.println("authority profile created successfully...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "valid";
        }
        else {
            System.out.println("please enter correct info");
            return "invalid";
        }

    }

    public boolean validateAuthority(String tax, String pass){
        String QUERY = "SELECT EXISTS(SELECT * from authority WHERE tax='" +tax + "');";
        String QUERY2 = "SELECT authpassword from authority WHERE tax='" + tax + "';";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();

        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);

            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from authority WHERE tax='" + tax + "')");
            }
            if (valid == 1) {
                rs = stmt.executeQuery(QUERY2);
                while (rs.next()) {
                    //Display values
                    String x = rs.getString("authpassword");
                    if(x.equals(pass)){
                        valid = 1;
                    }else {
                        valid = 0;
                    }
                }
                if (valid == 1){
                    return true;
                }else {
                    System.out.println("incorrect password");
                    return false;
                }
            } else if (valid == 0) {
                System.out.println("incorrect tax");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }
    public boolean checkForNoduplicateAuthorities(String tax){
        int num=0;
        DB start = new DB();
        final String QUERY = "select count(*) from authority where tax=" + "\"" + tax+ "\"" +";";
        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                num = rs.getInt("count(*)");
                System.out.println("rs=="+num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(num!=0){
            return true;
        }
        return false;
    }

}
